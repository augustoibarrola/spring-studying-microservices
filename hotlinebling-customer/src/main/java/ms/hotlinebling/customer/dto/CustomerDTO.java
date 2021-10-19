package ms.hotlinebling.customer.dto;

import java.util.List;

import ms.hotlinebling.customer.entity.Customer;

public class CustomerDTO 
{
	long phoneNumber;
	String name;
	int age;
	String address;
	PlanDTO currentPlan;
	String password;
	PhoneDTO currentPhone;
	
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
	public PlanDTO getCurrentPlan() {
		return currentPlan;
	}
	public void setCurrentPlan(PlanDTO plan) {
		this.currentPlan = plan;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PhoneDTO getCurrentPhone() {
		return currentPhone;
	}
	public void setCurrentPhone(PhoneDTO currentPhone) {
		this.currentPhone = currentPhone;
	}
	public static CustomerDTO valueOf(Customer customer)
	{
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setName(customer.getName());
		customerDTO.setAge(customer.getAge());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setPassword(customer.getPassword());
		
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setPhoneId(customer.getPhoneId());
		customerDTO.setCurrentPhone(phoneDTO);
		
		PlanDTO planDTO = new PlanDTO();
		planDTO.setPlanId(customer.getPlanId());
		customerDTO.setCurrentPlan(planDTO);

		
		return customerDTO;
	}
	
}
