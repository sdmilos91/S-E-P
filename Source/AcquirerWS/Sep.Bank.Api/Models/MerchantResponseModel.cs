using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Sep.Bank.Api.Models
{
    public class MerchantResponseModel
    {
        public string PaymentID { get; set; }
        public string PaymentURL { get; set; }
    }
}