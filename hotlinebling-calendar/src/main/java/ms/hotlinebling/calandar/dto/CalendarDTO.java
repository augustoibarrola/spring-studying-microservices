package ms.hotlinebling.calandar.dto;

import java.util.Date;

import ms.hotlinebling.calandar.entity.Calendar;
public class CalendarDTO 
{
	
	private int id;
//	private CustomerDTO customerDTO;
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
	
	public static CalendarDTO valueOf(Calendar calendar) {
		
		CalendarDTO calendarDTO = new CalendarDTO();
		
		calendarDTO.setId(calendar.getId());
		calendarDTO.setDescription(calendar.getDescription());
		calendarDTO.setYear(calendar.getYear());
		calendarDTO.setDate(calendar.getDate());
		calendarDTO.setTime(calendar.getTime());
		calendarDTO.setDatetime(calendar.getDatetime());
		
//		CustomerDTO customerDTO = new CustomerDTO();
//		customerDTO.setPhoneNumber(calandar.getCustomerId());
//		
//		calandarDTO.setCustomerDTO(customerDTO);
		
		
		return calendarDTO;
	}

}
