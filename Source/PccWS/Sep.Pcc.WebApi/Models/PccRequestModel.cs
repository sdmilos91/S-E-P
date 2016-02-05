using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Sep.Pcc.WebApi.Models
{
    public class PccRequestModel
    {
        public long AcquirerID { get; set; }
        public DateTime AcquirerTimestamp { get; set; }
        public string CardPAN { get; set; }
        public string CardSecurityCode { get; set; }
        public string CardHolderName { get; set; }
        public DateTime CardValidThru { get; set; }
        public decimal Amount { get; set; }
    }
}