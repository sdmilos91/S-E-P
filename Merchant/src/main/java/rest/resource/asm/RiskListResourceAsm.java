package rest.resource.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import core.services.util.RiskList;
import rest.mvc.RiskController;
import rest.resource.RiskListResource;

public class RiskListResourceAsm extends ResourceAssemblerSupport<RiskList,RiskListResource> {
		 
		 public RiskListResourceAsm() {
	        super(RiskController.class, RiskListResource.class);
	    }


	    public RiskListResource toResource(RiskList riskList) {
	    	RiskListResource res = new RiskListResource();
	        res.setRisks(new RiskResourceAsm().toResources(riskList.getRisks()));
	        return res;
	    }		
}
