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
	@Column(name = "customer_id")
	int id;
//	@Column(nullable = false)
	long phoneNumber;
	@Column(name = "customer_name")
	String name;
//	@Column(nullable = false)
	int age;
//	@Column(nullable = false)
	String address;
//	@Column(nullable = false)
	int planId;
	int phoneId;
//	@Column(nullable = false)
	String password;
//	@Column(nullable = false)

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public static Customer valueOf(CustomerDTO postCustomer) 
	{
		Customer customer = new Customer();
		
		customer.setPhoneNumber(postCustomer.getPhoneNumber());
		customer.setName(postCustomer.getName());
		customer.setAge(postCustomer.getAge());
		customer.setAddress(postCustomer.getAddress());
		customer.setPassword(postCustomer.getPassword());
		
		return customer;
	}

}

/*
 * CREATE TABLE Customer( phone_number BIGINT PRIMARY KEY, customer_name
 * VARCHAR(50), age INTEGER, address VARCHAR(50), plan_id INTEGER, password
 * VARCHAR(50) );
 */