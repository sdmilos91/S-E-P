package core.repositories;

import core.models.entities.Merchant;

public interface MerchantRepo {
	
	public Merchant findMerchant(String JMBG);
	public Merchant createMerchant(Merchant data);
	
}
