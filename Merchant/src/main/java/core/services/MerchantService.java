package core.services;

import core.models.entities.Merchant;

public interface MerchantService  {
	
	public Merchant findMerchant(String merchantId);

	public Merchant createMerchant(Merchant data);
	
}

