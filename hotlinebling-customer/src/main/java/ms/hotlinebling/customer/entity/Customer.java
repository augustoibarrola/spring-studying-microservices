package ms.hotlinebling.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue
	long phoneNumber;
	@Column(name = "customer_name", nullable = false)
	String name;
	@Column(nullable = false)
	int age;
	@Column(nullable = false)
	String address;
	@Column(nullable = false)
	int planId;
	@Column(nullable = false)
	String password;

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

}

/*
 * CREATE TABLE Customer( phone_number BIGINT PRIMARY KEY, customer_name
 * VARCHAR(50), age INTEGER, address VARCHAR(50), plan_id INTEGER, password
 * VARCHAR(50) );
 */