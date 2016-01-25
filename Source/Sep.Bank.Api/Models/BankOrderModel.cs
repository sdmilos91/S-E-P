using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Sep.Bank.Api.Models
{
    public class BankOrderModel
    {
        public long PaymentID { get; set; }
        public string CardPAN { get; set; }
        public string CardSecurityCode { get; set; }
        public string CardHolderName { get; set; }
        public DateTime CardValidThru { get; set; }
    }
}