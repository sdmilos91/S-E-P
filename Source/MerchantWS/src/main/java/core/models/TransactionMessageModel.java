package core.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionMessageModel {
	
	@JsonProperty("Data")
	private BankOrderModel bankOrderResponseModel;
	
	@JsonProperty("IsError")
	private boolean isError;
	
	private String ErrorMessage;

	@JsonProperty("Data")
	public BankOrderModel getBankOrderResponseModel() {
		return bankOrderResponseModel;
	}

	@JsonProperty("Data")
	public void setBankOrderResponseModel(BankOrderModel bankOrderResponseModel) {
		this.bankOrderResponseModel = bankOrderResponseModel;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	
}
