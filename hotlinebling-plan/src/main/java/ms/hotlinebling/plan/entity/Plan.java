package ms.hotlinebling.plan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ms.hotlinebling.plan.dto.PlanDTO;

@Entity
@Table(name="Plan")
public class Plan 
{
	@Id
	@Column(name = "plan_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer planId;
	@Column(name = "plan_name")
	String planName;
	@Column(name = "local_rate")
	Integer localRate;
	
	public Integer getPlanId() {
		return this.planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return this.planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getLocalRate() {
		return this.localRate;
	}
	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}
	public static Plan valueOf(PlanDTO newPlan) {
		
		Plan plan = new Plan();
		
		plan.setPlanId(newPlan.getPlanId());
		plan.setPlanName(newPlan.getPlanName());
		plan.setLocalRate(newPlan.getLocalRate());
		
	
		return plan;
	}

}
