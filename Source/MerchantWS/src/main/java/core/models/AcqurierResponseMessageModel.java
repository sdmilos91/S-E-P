package core.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AcqurierResponseMessageModel {

	@JsonProperty("PaymentID")
	private String PaymentID;
	@JsonProperty("PaymentURL")
	private String PaymentURL;

	@JsonProperty("PaymentID")
	public String getPaymentID() {
		return PaymentID;
	}

	@JsonProperty("PaymentID")
	public void setPaymentID(String paymentID) {
		PaymentID = paymentID;
	}

	@JsonProperty("PaymentURL")
	public String getPaymentURL() {
		return PaymentURL;
	}

	@JsonProperty("PaymentURL")
	public void setPaymentURL(String paymentURL) {
		PaymentURL = paymentURL;
	}
	
	
}
