using Newtonsoft.Json;
using Sep.Bank.Api.Helpers;
using Sep.Bank.Api.Models;
using Sep.Bank.DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Sep.Bank.Api.Controllers
{
    public class PccController : ApiController
    {

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
                        return Json(new { Error = true, ErrorMessage = "Transaction not exist!", Redirect = true });
                    }

                    long last = context.BANKORDERs.Count() > 0 ? context.BANKORDERs.OrderByDescending(x => x.BANKORDERTIMESTAMP).FirstOrDefault().BANKORDER_ID : 0;
                    long acquierID = GenerateNumber.GenerateTenDigitNumber(last);

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
                        BankOrderResponseModel bankOrderRespModel = new BankOrderResponseModel
                        {
                            PaymentID = transaction.PAYMENT_ID,
                            MerchantOrderID = transaction.TRANSACTIONORDERID

                        };
                        if (result.StatusCode == HttpStatusCode.OK)
                        {
                            PccResponseModel pccRespModel = (PccResponseModel)JsonConvert.DeserializeObject(resultContent, typeof(PccResponseModel));

                            if (!pccRespModel.IsError)
                            {
                                bankOrderRespModel.AcquirerID = pccRespModel.Data.AcquirerID;
                                bankOrderRespModel.AcquirerTimestamp = pccRespModel.Data.AcquirerTimestamp;

                                return Json(new { IsError = false, Data = bankOrderRespModel });
                            }
                        }

                        return Json(new { IsError = true, MessageError = resultContent, Redirect = true, Data = bankOrderRespModel });
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
                          .Where(y => y.Count > 0)
                          .ToList();

                return Json(new { IsError = true, ErrorMessage = "Invalid model!", Redirect = false, Errors = errors });

            }
        }

    }
}
