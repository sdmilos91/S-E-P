using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Sep.Bank.Api.Models
{
    public class BankOrderResponseModel
    {
        public long AcquirerID { get; set; }
        public DateTime AcquirerTimestamp { get; set; }
        public long MerchantOrderID { get; set; }
        public long PaymentID { get; set; }
    }
}