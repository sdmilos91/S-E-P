package core.services.util;

import java.util.ArrayList;
import java.util.List;

import core.models.entities.Risk;

public class RiskList {

	 private List<Risk> risks = new ArrayList<Risk>();

	    public List<Risk> getRisks() {
	        return risks;
	    }

	    public void setRisks(List<Risk> risks) {
	        this.risks = risks;
	    }
	    
}
