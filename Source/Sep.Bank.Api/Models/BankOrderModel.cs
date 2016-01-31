using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Sep.Bank.Api.Models
{
    public class BankOrderModel
    {
        [Required]
        public long PaymentID { get; set; }

        [Required]
        public string CardPAN { get; set; }

        [Required]
        public string CardSecurityCode { get; set; }

        [Required]
        public string CardHolderName { get; set; }

        [Required]
        public DateTime CardValidThru { get; set; }
    }
}