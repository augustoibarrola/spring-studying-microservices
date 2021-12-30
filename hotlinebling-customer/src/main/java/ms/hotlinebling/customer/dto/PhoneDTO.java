package ms.hotlinebling.customer.dto;

public class PhoneDTO 
{
	private int id;
	private String name;
	private String operatingSystem;
	
	public int getId() {
		return id;
	}
	public void setId(int phoneId) {
		this.id = phoneId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
}