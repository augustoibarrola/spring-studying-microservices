package ms.hotlinebling.plan.dto;

import ms.hotlinebling.plan.entity.Plan;

public class PlanDTO 
{
	Integer planId;
	String planName;
	Integer localRate;
	
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getLocalRate() {
		return localRate;
	}
	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}
	
	public static PlanDTO valueOf(Plan plan)
	{
		PlanDTO planDTO = new PlanDTO();
		planDTO.setPlanId(plan.getPlanId());
		planDTO.setPlanName(plan.getPlanName());
		planDTO.setLocalRate(plan.getLocalRate());
		
		return planDTO;
	}

}
