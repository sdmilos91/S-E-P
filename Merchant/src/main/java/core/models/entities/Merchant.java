package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "MERCHANT")
public class Merchant implements java.io.Serializable {

	@Id 
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "merchantPassword", nullable = false)
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
	
	
}
