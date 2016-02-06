using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Sep.Bank.Api.Models
{
    public class MerchantRequestModel
    {
        public string MerchantID { get; set; }
        public string MerchantPassword { get; set; }
        public decimal Amount { get; set; }
        public long MerchantOrderID { get; set; }
        public DateTime MerchantTimestamp { get; set; }
        public string ErrorUrl { get; set; }

    }
}