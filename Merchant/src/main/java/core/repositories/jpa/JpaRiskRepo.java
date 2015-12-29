package core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import core.models.entities.Risk;
import core.repositories.RiskRepo;
import core.services.util.RiskList;

@Repository
public class JpaRiskRepo implements RiskRepo {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public RiskList findRisks(String riskType) {
		List<Risk> risks = em.createQuery("select r from Risk r, RiskType rt where r.riskType.riskType_Id=rt.riskType_Id and rt.riskType like :riskType" ).setParameter("riskType", riskType).getResultList();
		RiskList riskList = new RiskList();
		riskList.setRisks(risks);
		return riskList;
	}

	public Risk findRisk(int riskId) {
		return em.find(Risk.class,riskId);
	}
	
}
