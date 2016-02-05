using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Sep.Pcc.DataAccess;
using Sep.Pcc.WebApi.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity.Validation;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Sep.Pcc.WebApi.Controllers
{
    public class PccController : ApiController
    {
        private static readonly long LIMIT = 10000000000L;
        private static readonly DateTime Jan1st1970 = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);

        public HttpResponseMessage ForwardOrder(PccRequestModel model)
        {

            if (ModelState.IsValid)
            { 
                try
                {
                    SepPccEntities context = new SepPccEntities();
                    string shortPan = model.CardPAN.Substring(0, 5);
                    BANK bank = context.BANKs.FirstOrDefault(x => x.PAN == shortPan);

                    if (bank == null)
                    {
                        return Request.CreateResponse(HttpStatusCode.BadRequest, "Bank with selected PAN not exist!");
                    }



                    TRANSACTION transaction = new TRANSACTION
                    {
                        TRANSACTIONID = Guid.NewGuid().ToString(),
                        TRANSACTIONTIMESTAMP = DateTime.Now
                    };

                    ACQURIERREQUEST acqReq = new ACQURIERREQUEST
                    {
                        ACQURIERTIMESTAMP = model.AcquirerTimestamp,
                        ACQURIERORDERID = model.AcquirerID,
                        CARDHOLDERNAME = model.CardHolderName,
                        DATE = model.CardValidThru,
                        PAN = model.CardPAN,
                        SECURIYCODE = model.CardSecurityCode
                    };

                    acqReq.TRANSACTIONs.Add(transaction);
                    context.ACQURIERREQUESTs.Add(acqReq);

                    
                    var modelJson = JsonConvert.SerializeObject(model); 

                    using (var client = new HttpClient()) 
                    {
                        var result = client.PostAsync(bank.SERVICEURL, new StringContent(modelJson, System.Text.Encoding.UTF8, "application/json")).Result;
                        string resultContent = result.Content.ReadAsStringAsync().Result;                       

                        if (result.StatusCode == HttpStatusCode.OK) 
                        {
                            IssuerResponseModel issuerModel = (IssuerResponseModel)JsonConvert.DeserializeObject(resultContent, typeof(IssuerResponseModel));

                            ISSUERRESPONSE issuer = new ISSUERRESPONSE
                            {
                                ACQURIERORDER_ID = issuerModel.AcquirerID,
                                ACQURIERTIMESTAMP = issuerModel.AcquirerTimestamp,
                                ISSUERORDEID = issuerModel.IssuerID,
                                ISSUERORDERTIMESTAMP = issuerModel.IssuerTimestamp,
                                PAN = bank.PAN.Trim()
                            };
                            issuer.TRANSACTIONs.Add(transaction);
                            context.ISSUERRESPONSEs.Add(issuer);
                            context.SaveChanges();

                            return Request.CreateResponse(HttpStatusCode.OK, new { IsError = false, Data = issuerModel});
                        }

                        JObject jsonErrorResponse = new JObject();
                        jsonErrorResponse.Add(new JProperty("IsError", true));
                        jsonErrorResponse.Add(new JProperty("Data", resultContent));

                        return Request.CreateResponse(HttpStatusCode.OK, jsonErrorResponse);


                    }
                }
                catch (Exception e)
                {
                    return Request.CreateResponse(HttpStatusCode.InternalServerError);
                }
                //catch (DbEntityValidationException dbEx)
                //{
                //    foreach (var validationErrors in dbEx.EntityValidationErrors)
                //    {
                //        foreach (var validationError in validationErrors.ValidationErrors)
                //        {
                //            Trace.TraceInformation("Property: {0} Error: {1}",
                //                                    validationError.PropertyName,
                //                                    validationError.ErrorMessage);
                //        }
                //    }
                //}
               
            }

            return Request.CreateResponse(HttpStatusCode.BadRequest, "Invalid model!");

        }
    }
}
