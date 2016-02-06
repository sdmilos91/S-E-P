package core.models;


public class ResponseOrderModel {

	private String merchantId;
	
	private String merchantPassword;
	
	private double amount;
	
	private long merchantOrderId;
	
	private String merchantTimestamp;
	
	private String errorUrl;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantPassword() {
		return merchantPassword;
	}

	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}

	public String getMerhcantPassword() {
		return merchantPassword;
	}

	public void setMerhcantPassword(String merhcantPassword) {
		this.merchantPassword = merhcantPassword;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(long merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public String getMerchantTimestamp() {
		return merchantTimestamp;
	}

	public void setMerchantTimestamp(String merchantTimestamp) {
		this.merchantTimestamp = merchantTimestamp;
	}

	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}
	
	
}
