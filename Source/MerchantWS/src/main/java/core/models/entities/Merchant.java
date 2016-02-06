package core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name = "MERCHANT")
public class Merchant implements java.io.Serializable {

	@Id 
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "merchantPassword", nullable = false)
	private String merchantPassword;
	
	@Column(name = "errorURL", nullable = false)
	private String errorURL;
	
	@Column(name = "successURL", nullable = false)
	private String successURL;
	
	@Column(name = "failedURL", nullable = false)
	private String failedURL;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getErrorURL() {
		return errorURL;
	}
	public void setErrorURL(String errorURL) {
		this.errorURL = errorURL;
	}
	public String getSuccessURL() {
		return successURL;
	}
	public void setSuccessURL(String successURL) {
		this.successURL = successURL;
	}
	public String getFailedURL() {
		return failedURL;
	}
	public void setFailedURL(String failedURL) {
		this.failedURL = failedURL;
	}
	
	
	
}