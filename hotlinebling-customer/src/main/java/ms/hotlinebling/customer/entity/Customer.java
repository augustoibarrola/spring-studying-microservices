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
	int id;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;
	@Column(name = "middle_name")
	String middleName;
	int age;
	long phoneNumber;
	String eMail;
	String address;
	@Column(name = "plan_id")
	int currentPlan;
	@Column(name = "phone_id")
	int currentPhone;
	String password;
	@Column(name = "ssn")
	Integer ssn;

	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
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


	public int getPlanId() {
		return currentPlan;
	}


	public void setPlanId(int planId) {
		this.currentPlan = planId;
	}


	public int getPhoneId() {
		return currentPhone;
	}


	public void setPhoneId(int phoneId) {
		this.currentPhone = phoneId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getSsn() {
		return ssn;
	}


	public void setSsn(int ssn) {
		this.ssn = ssn;
	}


	public static Customer valueOf(CustomerDTO postCustomer) 
	{
		Customer customer = new Customer();
		
		customer.setPhoneNumber(postCustomer.getPhoneNumber());
		customer.setFirstName(postCustomer.getFirstName());
		customer.setAge(postCustomer.getAge());
		customer.setAddress(postCustomer.getAddress());
		customer.setPassword(postCustomer.getPassword());
		
		return customer;
	}


	public static Customer updateEntity(Customer foundCustomer, CustomerDTO updateCustomer) {
		
		foundCustomer.firstName = updateCustomer.getFirstName();
		foundCustomer.middleName = updateCustomer.getMiddleName();
		foundCustomer.lastName = updateCustomer.getLastName();
		
		foundCustomer.age = updateCustomer.getAge();
		foundCustomer.phoneNumber = updateCustomer.getPhoneNumber();
		foundCustomer.eMail = updateCustomer.geteMail();
		foundCustomer.address = updateCustomer.getAddress();
		foundCustomer.password = updateCustomer.getPassword();
		foundCustomer.ssn = updateCustomer.getSsn();

//		foundCustomer.currentPlan = updateCustomer.getCurrentPlan().getId();
//		foundCustomer.currentPhone = updateCustomer.getCurrentPhone().getId();
		
		
		return foundCustomer;
	}

}