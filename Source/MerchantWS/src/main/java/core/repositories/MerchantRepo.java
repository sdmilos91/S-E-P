package core.repositories;

import core.models.entities.Merchant;

public interface MerchantRepo {
	
	public Merchant findMerchant(int id);
	public Merchant createMerchant(Merchant data);
	public Merchant getMerchantData();
	
}
