package ms.hotlinebling.customer.dto;

public class PlanDTO 
{
	Integer id;
	String name;
	Integer localRate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer planId) {
		this.id = planId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLocalRate() {
		return localRate;
	}
	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}
}
