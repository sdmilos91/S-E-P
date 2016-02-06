package core.models;

public class MerchantOrderResponseModel {
	
	private boolean error;
	
	private String paymentURL;
		
	private String errorMessage;

	private String paymentID;

	public boolean isError() {
		return error;
	}
	
	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getPaymentURL() {
		return paymentURL;
	}

	public void setPaymentURL(String paymentURL) {
		this.paymentURL = paymentURL;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
