//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Sep.Pcc.DataAccess
{
    using System;
    using System.Collections.Generic;
    
    public partial class ISSUERRESPONSE
    {
        public ISSUERRESPONSE()
        {
            this.TRANSACTIONs = new HashSet<TRANSACTION>();
        }
    
        public int ISSUER_RESPONSE_ID { get; set; }
        public long ACQURIERORDER_ID { get; set; }
        public string PAN { get; set; }
        public System.DateTime ACQURIERTIMESTAMP { get; set; }
        public long ISSUERORDEID { get; set; }
        public System.DateTime ISSUERORDERTIMESTAMP { get; set; }
    
        public virtual BANK BANK { get; set; }
        public virtual ICollection<TRANSACTION> TRANSACTIONs { get; set; }
    }
}
