package ms.hotlinebling.plan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ms.hotlinebling.plan.dto.PlanDTO;

@Entity
@Table(name="Plan")
public class Plan 
{
	@Id
	@Column(name = "plan_id", nullable = false)
	Integer planId;
	@Column(name = "plan_name", nullable = false)
	String planName;
	@Column(name = "local_rate", nullable = false)
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

}
