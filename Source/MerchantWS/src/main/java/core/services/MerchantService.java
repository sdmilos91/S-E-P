package core.services;

import core.models.entities.Merchant;

public interface MerchantService  {
	
	public Merchant findMerchant(int Id);

	public Merchant createMerchant(Merchant data);
	
	public Merchant getMerchantData();
	
}

