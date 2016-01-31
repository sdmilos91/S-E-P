using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Sep.Bank.Api.Models;
using Sep.Bank.DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Helpers;
using System.Web.Http;

namespace Sep.Bank.Api.Controllers
{
    public class BankController : ApiController
    {
        private static readonly long LIMIT = 10000000000L;
        private static readonly DateTime Jan1st1970 = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);


        /// <summary>
        /// Kreiranje transakcije za placanje
        /// </summary>
        /// <param name="model">Parametri narudzbine</param>
        /// <returns>Poruka o uspesnosti</returns>
        [HttpPost]
        [System.Web.Http.Cors.EnableCors(origins: "*", headers: "*", methods: "*")]
        public HttpResponseMessage CreateOrder([FromBody]MerchantRequestModel model)
        {
            try 
            {
                BankEntities context = new BankEntities();
                ACCOUNT account = context.ACCOUNTs.FirstOrDefault(x => x.MERCHANT_ID == model.MerchantID);
                if (ModelState.IsValid)
                {
                    if (account == null)
                    {
                        return Request.CreateResponse(HttpStatusCode.BadRequest, "There is no merchant with sent ID value!");
                    }
                    else if (!account.MERCHANT_PASSWORD.Equals(model.MerchantPassword))
                    {
                        return Request.CreateResponse(HttpStatusCode.BadRequest, "Incorect password for merchant!");
                    }

                    long last = context.TRANSACTIONs.Count() > 0 ? context.TRANSACTIONs.OrderByDescending(x => x.TRANSACTIONTIMESTAMP).FirstOrDefault().PAYMENT_ID : 0;
                    long paymentID = GenerateTenDigitNumber(last);

                    TRANSACTION transaction = new TRANSACTION
                    {
                        AMOUNT = model.Amount,
                        TRANSACTIONORDERID = model.MerchantOrderID,
                        TRANSACTIONTIMESTAMP = model.MerchantTimestamp,
                        PAYMENT_ID = paymentID
                    };

                    context.TRANSACTIONs.Add(transaction);
                    context.SaveChanges();

                    string bankWebAppURL = System.Configuration.ConfigurationManager.AppSettings["BankWebApp"];

                    MerchantResponseModel responseModel = new MerchantResponseModel();
                    responseModel.PaymentID = paymentID.ToString();
                    responseModel.PaymentURL = string.Format("{0}{1}", bankWebAppURL, paymentID);
                    
                    return Request.CreateResponse(HttpStatusCode.OK, responseModel);
                }
                else
                {
                    return Request.CreateResponse(HttpStatusCode.BadRequest, "Bad model!");
                }
            }
            catch
            {
                return Request.CreateResponse(HttpStatusCode.InternalServerError);
            }

            
        }

        /// <summary>
        /// Slanje podataka PCC servisu za kako bi prosledio potrebne podatke banki kupca
        /// </summary>
        /// <param name="model">Model podataka koji se salje PCC-u</param>
        /// <returns>Odgovor banke kupca koji prosledjuje PCC</returns>
        [HttpPost]
        [System.Web.Http.Cors.EnableCors(origins: "*", headers: "*", methods: "*")]
        public IHttpActionResult SendOrder([FromBody]BankOrderModel model) 
        {
            if (ModelState.IsValid)
            {
                try
                {
                    BankEntities context = new BankEntities();
                    TRANSACTION transaction = context.TRANSACTIONs.FirstOrDefault(x => x.PAYMENT_ID == model.PaymentID);
                    if (transaction == null)
                    {
                        return Json(new { Error = true, ErrorMessage = "Transaction didnt exist!", Redirect = true });
                    }

                    long last = context.BANKORDERs.Count() > 0 ? context.BANKORDERs.OrderByDescending(x => x.BANKORDERTIMESTAMP).FirstOrDefault().BANKORDER_ID : 0;
                    long acquierID = GenerateTenDigitNumber(last);

                    CREDITCARD creditCard = context.CREDITCARDs.FirstOrDefault(x => x.PAN == model.CardPAN);

                    if (creditCard == null)
                    {
                        creditCard = new CREDITCARD
                        {
                            CARDHOLDERNAME = model.CardHolderName,
                            DATE = model.CardValidThru,
                            PAN = model.CardPAN,
                            SECURITYCODE = model.CardSecurityCode
                        };
                    }
                    BANKORDER order = new BANKORDER
                    {
                        PAYMENT_ID = model.PaymentID,
                        BANKORDER_ID = acquierID,
                        BANKORDERTIMESTAMP = DateTime.Now
                    };

                    order.CREDITCARD = creditCard;
                    order.TRANSACTION = transaction;

                    context.BANKORDERs.Add(order);
                    context.SaveChanges();
                    PccRequestModel pccModel = new PccRequestModel
                    {
                        AcquirerID = order.BANKORDER_ID,
                        AcquirerTimestamp = order.BANKORDERTIMESTAMP,
                        CardHolderName = model.CardHolderName,
                        CardPAN = model.CardPAN,
                        CardSecurityCode = model.CardSecurityCode,
                        CardValidThru = model.CardValidThru,
                        Amount = transaction.AMOUNT
                    };

                    string pccServiceURL = System.Configuration.ConfigurationManager.AppSettings["PccServiceURl"];

                    var modelJson = JsonConvert.SerializeObject(pccModel);

                    using (var client = new HttpClient())
                    {
                        var result = client.PostAsync(pccServiceURL, new StringContent(modelJson, System.Text.Encoding.UTF8, "application/json")).Result;
                        string resultContent = result.Content.ReadAsStringAsync().Result;

                        if (result.StatusCode == HttpStatusCode.OK)
                        {
                            PccResponseModel pccRespModel = (PccResponseModel)JsonConvert.DeserializeObject(resultContent, typeof(PccResponseModel));

                            if (!pccRespModel.IsError)
                            {
                                BankOrderResponseModel bankOrderRespModel = new BankOrderResponseModel
                                {
                                    AcquirerID = pccRespModel.Data.AcquirerID,
                                    AcquirerTimestamp = pccRespModel.Data.AcquirerTimestamp,
                                    PaymentID = transaction.PAYMENT_ID,
                                    MerchantOrderID = transaction.TRANSACTIONORDERID

                                };

                                return Json(new { IsError = false, Data = bankOrderRespModel });
                            }
                        }

                        return Json(new { IsError = true, MessageError = resultContent, Redirect = true });
                    }
                }
                catch
                {
                    return Json(new { IsError = true, ErrorMessage = "Server error!", Redirect = true });
                }
            }
            else
            {
                 var errors = ModelState.Select(x => x.Value.Errors)
                           .Where(y=>y.Count>0)
                           .ToList();

                 return Json(new { IsError = true, ErrorMessage = "Invalid model!", Redirect = false, Errors = errors });
            
            }
        }

        /// <summary>
        /// Provera podataka koje je prosledio PCC radi provere transakcije (Kada se banka ponasa kao banka kupca)
        /// </summary>
        /// <param name="model">Podaci koje salje banka prodavca, a koje prosledjuje PCC</param>
        /// <returns>Poruka o uspesnosti transakcije</returns>
        [HttpPost]
        [System.Web.Http.Cors.EnableCors(origins: "*", headers: "*", methods: "*")]
        public HttpResponseMessage CheckOrder([FromBody]PccRequestModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    BankEntities context = new BankEntities();

                    CREDITCARD creditCard = context.CREDITCARDs.FirstOrDefault(x => x.PAN == model.CardPAN);
                    if (creditCard == null)
                    {
                        return Request.CreateResponse(HttpStatusCode.BadRequest, "Bad PAN!");
                    }

                    if (creditCard.ACCOUNT == null)
                    {
                        return Request.CreateResponse(HttpStatusCode.BadRequest, "Invalid card parameters!");
                    }

                    ACCOUNT account = creditCard.ACCOUNT;

                    if (account.AMMOUNT < model.Amount)
                    {
                        return Request.CreateResponse(HttpStatusCode.BadRequest, "There is not enough money in the account!");
                    }

                    long last = context.TRANSACTIONs.Count() > 0 ? context.TRANSACTIONs.OrderByDescending(x => x.TRANSACTIONTIMESTAMP).FirstOrDefault().PAYMENT_ID : 0;
                    long paymentID = GenerateTenDigitNumber(last);

                    TRANSACTION transaction = new TRANSACTION
                    {

                        AMOUNT = model.Amount,
                        TRANSACTIONORDERID = model.AcquirerID,
                        TRANSACTIONTIMESTAMP = model.AcquirerTimestamp,
                        PAYMENT_ID = paymentID
                    };

                    long lastOrderID = context.BANKORDERs.Count() > 0 ? context.BANKORDERs.OrderByDescending(x => x.BANKORDERTIMESTAMP).FirstOrDefault().BANKORDER_ID : 0;
                    long OrderID = GenerateTenDigitNumber(last);

                   BANKORDER order = new BANKORDER
                   {
                       BANKORDER_ID = OrderID,
                       BANKORDERTIMESTAMP = DateTime.Now,
                       CREDITCARD = creditCard,
                       IS_ISSUER = true,
                       TRANSACTION = transaction
                   };

                   account.AMMOUNT -= model.Amount;
                   context.BANKORDERs.Add(order);
                   context.SaveChanges();

                   IssuerResponseModel issuerModel = new IssuerResponseModel
                   {
                       AcquirerID = model.AcquirerID,
                       AcquirerTimestamp = model.AcquirerTimestamp,
                       IssuerID = order.BANKORDER_ID,
                       IssuerTimestamp = order.BANKORDERTIMESTAMP
                   };

                   return Request.CreateResponse(HttpStatusCode.OK, issuerModel);
                }
                catch
                {
                    return Request.CreateResponse(HttpStatusCode.InternalServerError);
                }      
            }

            return Request.CreateResponse(HttpStatusCode.BadRequest, "Invalid model");
        }

        #region Private Methods

        /// <summary>
        /// Generisanje desetocifrenog broja
        /// </summary>
        /// <param name="last">Prosledjuje se poslednji generisan broj zbog provere jedinstvenosti</param>
        /// <returns>Jedinstven desetocifren broj</returns>
        private long GenerateTenDigitNumber(decimal last)
        {
            // 10 digits.
            decimal currentTimeMillis = CurrentTimeMillis();
            decimal id = currentTimeMillis % LIMIT;
            if (id <= last)
            {
                id = (last + 1) % LIMIT;
            }
            return (long)id;
        }

        private long CurrentTimeMillis()
        {
            return (long)(DateTime.UtcNow - Jan1st1970).TotalMilliseconds;
        }
        #endregion

    }
}
