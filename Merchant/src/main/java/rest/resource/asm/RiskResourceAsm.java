package rest.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import core.models.entities.Risk;
import rest.mvc.RiskController;
import rest.resource.RiskResource;

public class RiskResourceAsm extends ResourceAssemblerSupport<Risk,RiskResource> {

	public RiskResourceAsm() {
		super(RiskController.class,RiskResource.class);
	}
	public RiskResource toResource(Risk risk) {
		RiskResource res = new RiskResource();
		res.setRisk_Id(risk.getRisk_Id());
		res.setValue(risk.getValue());
		res.setCoef(risk.getCoef());
		res.setFlag(risk.isFlag());
		res.setValidTo(risk.getValidTo());
		res.setValidFrom(risk.getValidFrom());
		Link link = linkTo(methodOn(RiskController.class).getRisk(risk.getRisk_Id())).withSelfRel();
		res.add(link.withSelfRel());
		return res;
	}

}
