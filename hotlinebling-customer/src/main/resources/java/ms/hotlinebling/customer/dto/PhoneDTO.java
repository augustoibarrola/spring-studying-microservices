package ms.hotlinebling.customer.dto;

public class PhoneDTO 
{
	private Integer id;
	private String name;
	private String operatingSystem;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer phoneId) {
		this.id = phoneId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperatingSystem() {
		return this.operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
}