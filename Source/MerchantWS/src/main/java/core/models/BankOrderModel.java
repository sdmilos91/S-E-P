package core.models;


import com.fasterxml.jackson.annotation.JsonProperty;


public class BankOrderModel {

	@JsonProperty("AcquirerID")
	private long AcquirerID;
	@JsonProperty("AcquirerTimestamp")
	private String AcquirerTimestamp;
	@JsonProperty("MerchantOrderID")
	private long MerchantOrderID;
	@JsonProperty("PaymentID")
	private long PaymentID;

	/**
	* 
	* @return
	* The AcquirerID
	*/
	@JsonProperty("AcquirerID")
	public long getAcquirerID() {
	return AcquirerID;
	}

	/**
	* 
	* @param AcquirerID
	* The AcquirerID
	*/
	@JsonProperty("AcquirerID")
	public void setAcquirerID(long AcquirerID) {
	this.AcquirerID = AcquirerID;
	}

	/**
	* 
	* @return
	* The AcquirerTimestamp
	*/
	@JsonProperty("AcquirerTimestamp")
	public String getAcquirerTimestamp() {
	return AcquirerTimestamp;
	}

	/**
	* 
	* @param AcquirerTimestamp
	* The AcquirerTimestamp
	*/
	@JsonProperty("AcquirerTimestamp")
	public void setAcquirerTimestamp(String AcquirerTimestamp) {
	this.AcquirerTimestamp = AcquirerTimestamp;
	}

	/**
	* 
	* @return
	* The MerchantOrderID
	*/
	@JsonProperty("MerchantOrderID")
	public long getMerchantOrderID() {
	return MerchantOrderID;
	}

	/**
	* 
	* @param MerchantOrderID
	* The MerchantOrderID
	*/
	@JsonProperty("MerchantOrderID")
	public void setMerchantOrderID(long MerchantOrderID) {
	this.MerchantOrderID = MerchantOrderID;
	}

	/**
	* 
	* @return
	* The PaymentID
	*/
	@JsonProperty("PaymentID")
	public long getPaymentID() {
	return PaymentID;
	}

	/**
	* 
	* @param PaymentID
	* The PaymentID
	*/
	@JsonProperty("PaymentID")
	public void setPaymentID(long PaymentID) {
	this.PaymentID = PaymentID;
	}


     
}
