package ms.hotlinebling.phone.dto;

import ms.hotlinebling.phone.entity.Phone;

public class PhoneDTO 
{
	private int phoneId;
	private String name;
	private String operatingSystem;
	
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
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
	public static PhoneDTO valueOf(Phone phone) {
		PhoneDTO phoneDTO = new PhoneDTO();
		
		phoneDTO.setPhoneId(phone.getPhoneId());
		phoneDTO.setName(phone.getName());
		phoneDTO.setOperatingSystem(phone.getOperatingSystem());
		
		return phoneDTO;
	}
	
}