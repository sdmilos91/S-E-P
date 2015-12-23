package rest.mvc;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import core.models.entities.Merchant;
import core.services.MerchantService;
import rest.resource.MerchantResource;
import rest.resource.asm.MerchantResourceAsm;

@Controller
public class MerchantController {
	
	private MerchantService service;
	
	@Autowired
	public MerchantController(MerchantService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/rest/merchants/{merchantId}", method = RequestMethod.GET)
	public ResponseEntity<MerchantResource> getMerchant(
			@PathVariable String merchantId) {
		
		Merchant merchant = service.findMerchant(merchantId);
		MerchantResource res = new MerchantResourceAsm().toResource(merchant);
		return new ResponseEntity<MerchantResource>(res,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/rest/merchants", method = RequestMethod.POST)
	public ResponseEntity<MerchantResource> createMerchant(@RequestBody MerchantResource sentMerchant) {
		
		Merchant createdMerchant = service.createMerchant(sentMerchant.toMerchant());
		MerchantResource res = new MerchantResourceAsm().toResource(createdMerchant);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(res.getLink("self").getHref()));
        return new ResponseEntity<MerchantResource>(res, headers, HttpStatus.CREATED);
	}

}
