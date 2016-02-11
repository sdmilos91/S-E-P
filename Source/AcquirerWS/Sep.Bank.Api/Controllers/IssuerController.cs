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
    public class IssuerController : ApiController
    {
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

                    CREDITCARD creditCard = context.CREDITCARDs.FirstOrDefault(x => x.PAN == model.CardPAN && x.SECURITYCODE == model.CardSecurityCode);
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
                    long paymentID = GenerateNumber.GenerateTenDigitNumber(last);

                    TRANSACTION transaction = new TRANSACTION
                    {

                        AMOUNT = model.Amount,
                        TRANSACTIONORDERID = model.AcquirerID,
                        TRANSACTIONTIMESTAMP = model.AcquirerTimestamp,
                        PAYMENT_ID = paymentID
                    };

                    long lastOrderID = context.BANKORDERs.Count() > 0 ? context.BANKORDERs.OrderByDescending(x => x.BANKORDERTIMESTAMP).FirstOrDefault().BANKORDER_ID : 0;
                    long OrderID = GenerateNumber.GenerateTenDigitNumber(last);

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

    }
}
