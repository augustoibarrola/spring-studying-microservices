package ms.hotlinebling.customer.dto;

public class PlanDTO 
{
	private Integer id;
	private String name;
	private Integer localRate;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer planId) {
		this.id = planId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLocalRate() {
		return this.localRate;
	}
	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}
}
