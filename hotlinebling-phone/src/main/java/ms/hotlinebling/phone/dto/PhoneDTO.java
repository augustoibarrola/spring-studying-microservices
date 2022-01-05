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
	public String toString()
	{
		String id = String.valueOf(getPhoneId());
		String name = getName();
		String OS = getOperatingSystem();
		
		return "\n Phone: " + 
				"\n\t ID: " + id + 
				"\n\t NAME: " + name + 
				"\n\t OPERATING SYSTEM: " + OS + "\n";
	}
	public static String idsToString(List<PhoneDTO> phoneDTOs ) {
		
		StringBuffer phoneIDs = new StringBuffer("\n Phones: [ ");
		
		for(PhoneDTO phoneDTO : phoneDTOs)
		{
			phoneIDs.append(String.valueOf(phoneDTO.getPhoneId()) + ", ");
		}
		
		phoneIDs.append("]\n");
		return phoneIDs.toString();
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