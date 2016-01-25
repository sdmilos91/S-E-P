using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Sep.Bank.Api.Models
{
    public class IssuerResponseModel
    {
        public long AcquirerID { get; set; }
        public DateTime AcquirerTimestamp { get; set; }
        public long IssuerID { get; set; }
        public DateTime IssuerTimestamp { get; set; }
    }
}