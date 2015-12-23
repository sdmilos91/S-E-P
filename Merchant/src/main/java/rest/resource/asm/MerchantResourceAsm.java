package rest.resource.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import core.models.entities.Merchant;
import rest.mvc.MerchantController;
import rest.resource.MerchantResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;

public class MerchantResourceAsm extends ResourceAssemblerSupport<Merchant,MerchantResource>{

	public MerchantResourceAsm() {
		super(MerchantController.class, MerchantResource.class);
		
	}

	public MerchantResource toResource(Merchant merchant) {
		
		MerchantResource res = new MerchantResource();
		res.setMerchantId(merchant.getMerchantId());
		res.setMerchantPassword(merchant.getMerchantPassword());
		Link link = linkTo(methodOn(MerchantController.class).getMerchant(merchant.getMerchantId())).withSelfRel();
		res.add(link.withSelfRel());
		return res;
	}

}
