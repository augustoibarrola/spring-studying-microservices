package ms.hotlinebling.phone.dto;

import java.util.ArrayList;
import java.util.List;

import ms.hotlinebling.phone.entity.Phone;

public class PhoneDTO 
{
	private Integer phoneId;
	private String name;
	private String operatingSystem;
	
	public Integer getPhoneId() {
		return this.phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
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
	public static PhoneDTO valueOf(Phone phone) {
		PhoneDTO phoneDTO = new PhoneDTO();
		
		phoneDTO.setPhoneId(phone.getPhoneId());
		phoneDTO.setName(phone.getName());
		phoneDTO.setOperatingSystem(phone.getOperatingSystem());
		
		return phoneDTO;
	}
	public static List<PhoneDTO> valueOf(List<Phone> phones) {
		
		List<PhoneDTO> phoneDTOs = new ArrayList<>();
		
		for(Phone phone : phones)
		{
			phoneDTOs.add(PhoneDTO.valueOf(phone));
		}
		
		return phoneDTOs;
		
	}
	
}