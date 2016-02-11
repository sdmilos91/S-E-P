using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Sep.Bank.Api.Helpers;
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
                    long paymentID = GenerateNumber.GenerateTenDigitNumber(last);

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
    }
}
