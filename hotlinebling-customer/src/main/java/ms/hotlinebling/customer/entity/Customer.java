package ms.hotlinebling.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ms.hotlinebling.customer.dto.CustomerDTO;
import ms.hotlinebling.customer.dto.PhoneDTO;
import ms.hotlinebling.customer.dto.PlanDTO;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	Integer id;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;
	@Column(name = "middle_name")
	String middleName;
	Integer age;
	long phoneNumber;
	String eMail;
	String address;
	@Column(name = "plan_id")
	Integer currentPlan;
	@Column(name = "phone_id")
	Integer currentPhone;
	String password;
	@Column(name = "ssn")
	Integer ssn;

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getPlanId() {
		return currentPlan;
	}


	public void setPlanId(Integer planId) {
		this.currentPlan = planId;
	}


	public Integer getPhoneId() {
		return currentPhone;
	}


	public void setPhoneId(Integer phoneId) {
		this.currentPhone = phoneId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getSsn() {
		return ssn;
	}


	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}


	public static Customer valueOf(CustomerDTO postCustomer) 
	{
		Customer customer = new Customer();
		
		customer.setFirstName(postCustomer.getFirstName());
		customer.setMiddleName(postCustomer.getMiddleName());
		customer.setLastName(postCustomer.getLastName());
		
		customer.setAge(postCustomer.getAge());
		customer.setPhoneNumber(postCustomer.getPhoneNumber());
		
		customer.seteMail(postCustomer.geteMail());
		customer.setAddress(postCustomer.getAddress());
		
		customer.setPassword(postCustomer.getPassword());
		customer.setSsn(postCustomer.getSsn());
		
		return customer;
	}


	public static Customer updateEntity(Customer foundCustomer, CustomerDTO updateCustomer) {
			
	
		foundCustomer.setFirstName(updateCustomer.getFirstName());
		foundCustomer.setMiddleName(updateCustomer.getMiddleName());
		foundCustomer.setLastName(updateCustomer.getLastName());
		foundCustomer.setAge(updateCustomer.getAge());
		foundCustomer.setPhoneNumber(updateCustomer.getPhoneNumber());
		foundCustomer.seteMail(updateCustomer.geteMail());
		foundCustomer.setAddress(updateCustomer.getAddress());
		foundCustomer.setPassword(updateCustomer.getPassword());
		foundCustomer.setSsn(updateCustomer.getSsn());

//		foundCustomer.currentPlan = updateCustomer.getCurrentPlan().getId();
//		foundCustomer.currentPhone = updateCustomer.getCurrentPhone().getId();
		
		return foundCustomer;
	}

}