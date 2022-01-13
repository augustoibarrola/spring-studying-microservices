package ms.hotlinebling.calandar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ms.hotlinebling.calandar.dto.CalendarDTO;

@Entity
@Table(name = "Event")
public class Calendar 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private int id;
	@Column(name="customer_id")
	private Integer customerId;
	private String description;
	@Column(name="event_year")
	private String year;
	@Column(name="event_date") //YYYY-MM-DD
	private String date;
	@Column(name="event_time") //hh:mm:ss
	private String time;
	@Column(name="event_datetime") //YYYY-MM-DDThh:mm:ss
	private Date datetime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	public static Calendar valueOf(CalendarDTO postEvent) {

		Calendar calendar = new Calendar();
		calendar.setCustomerId(1);
		calendar.setDate(postEvent.getDate());
		calendar.setDatetime(postEvent.getDatetime());
		calendar.setDescription(postEvent.getDescription());
		calendar.setId(postEvent.getId());
		calendar.setTime(postEvent.getTime());
		calendar.setYear(postEvent.getYear());
		
		return calendar;
	}
}
