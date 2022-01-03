package ms.hotlinebling.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ms.hotlinebling.phone.dto.PhoneDTO;

@Entity
@Table(name = "Phone")
public class Phone 
{
	@Id
	@GeneratedValue
	@Column(name = "phone_id", nullable = false)
	private Integer phoneId;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "os", nullable = false)
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
	
	public static Phone valueOf(PhoneDTO phoneDTO) {
		Phone phone = new Phone();
		
		phone.setPhoneId(phoneDTO.getPhoneId());
		phone.setName(phoneDTO.getName());
		phone.setOperatingSystem(phoneDTO.getOperatingSystem());
		
		return phone;
	}
	
}