package ms.hotlinebling.calandar.dto;

import java.util.Date;

import ms.hotlinebling.calandar.entity.Calandar;
public class CalandarDTO 
{
	
	private int id;
	private CustomerDTO customerDTO;
	private String description;
	private String year;
	private String date;
	private String time;
	private Date datetime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	public static CalandarDTO valueOf(Calandar calandar) {
		
		CalandarDTO calandarDTO = new CalandarDTO();
		
		calandarDTO.setId(calandar.getId());
		calandarDTO.setDescription(calandar.getDescription());
		calandarDTO.setYear(calandar.getYear());
		calandarDTO.setDate(calandar.getDate());
		calandarDTO.setTime(calandar.getTime());
		calandarDTO.setDatetime(calandar.getDatetime());
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setPhoneNumber(calandar.getCustomerId());
		
		calandarDTO.setCustomerDTO(customerDTO);
		
		
		return calandarDTO;
	}

}
