package rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class RiskListResource extends ResourceSupport  {

	 private List<RiskResource> risks = new ArrayList<RiskResource>();

	 public List<RiskResource> getRisks() {
	      return risks;
	 }

	 public void setRisks(List<RiskResource> risks) {
	     this.risks = risks;
	 }
}
