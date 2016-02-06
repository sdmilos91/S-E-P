package rest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import core.models.entities.Risk;
import core.services.RiskService;
import core.services.util.RiskList;

@Controller
public class RiskController {

	private RiskService service;
	
	@Autowired
	public RiskController(RiskService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@RequestMapping(value="/rest/risk/{riskId}", method = RequestMethod.GET)
	public ResponseEntity<Risk> getRisk(
			@PathVariable int riskId) {
		
		Risk risk = service.findRisk(riskId);
		return new ResponseEntity<Risk>(risk,HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/rest/risks/{riskType}", method = RequestMethod.GET)
	public ResponseEntity<RiskList> getRisks(
			@PathVariable String riskType) {
		
		RiskList risks = service.findRisks(riskType);
		return new ResponseEntity<RiskList>(risks,HttpStatus.OK);
		
	} 
}
