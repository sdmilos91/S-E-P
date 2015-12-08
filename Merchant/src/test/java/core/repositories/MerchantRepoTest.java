package core.repositories;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import core.models.entities.Merchant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class MerchantRepoTest {
	
	@Autowired
	private MerchantRepo repo;
	
	private Merchant merchant;
	
	@Before
	@Transactional
	@Rollback(false)
	public void setup() {
		merchant = new Merchant();
		merchant.setMerchantId("m1");
		merchant.setMerchantPassword("merch2231");
		repo.createMerchant(merchant);
	}
	
	@Test
	@Transactional
	public void testFind() {

		assertNotNull(repo.findMerchant(merchant.getMerchantId()));

	}

}
