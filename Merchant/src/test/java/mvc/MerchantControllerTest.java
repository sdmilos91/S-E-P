package mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import core.models.entities.Merchant;
import core.services.MerchantService;
import rest.mvc.MerchantController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class MerchantControllerTest {
	
	@InjectMocks
	private MerchantController controller;
	
	@Mock
	private MerchantService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void getExistingMerchant() throws Exception {
		Merchant merchant = new Merchant();
		merchant.setMerchantId("1");
		merchant.setMerchantPassword("merch1234");
		
		when(service.findMerchant("1")).thenReturn(merchant);
		
		mockMvc.perform(get("/rest/merchants/1"))
			.andDo(print())
			.andExpect(jsonPath("$.merchantPassword", is(merchant.getMerchantPassword())))
			.andExpect(status().isOk());
			//.addExpect(jsonPath("$.links[*].href", hasItem(endsWith("/merchants/1")))
			
	}
	
}