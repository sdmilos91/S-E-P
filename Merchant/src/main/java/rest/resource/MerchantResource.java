package rest.resource;


import org.springframework.hateoas.ResourceSupport;

import core.models.entities.Merchant;

public class MerchantResource extends ResourceSupport{
	
	private String merchantId;

	private String merchantPassword;
	
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
	
	 public Merchant toMerchant() {
		 
		 	Merchant merchant = new Merchant();
		 	merchant.setMerchantId(merchantId);
		 	merchant.setMerchantPassword(merchantPassword);	
	        return merchant;
	 }
}
