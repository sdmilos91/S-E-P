package core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.models.entities.Merchant;
import core.repositories.MerchantRepo;
import core.services.MerchantService;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {
	
	@Autowired
	private MerchantRepo repo;

	public Merchant findMerchant(int id) {
		
		return repo.findMerchant(id);
	}

	public Merchant createMerchant(Merchant data) {
		
		return repo.createMerchant(data);
	}
	
	public Merchant getMerchantData() {
		
		return repo.getMerchantData();
	}

}
