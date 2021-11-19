package ms.hotlinebling.customer.dto;

import java.util.ArrayList;
import java.util.List;

import ms.hotlinebling.customer.entity.Customer;

public class CustomerDTO 
{
	int id;
	long phoneNumber;
	String name;
	int age;
	String address;
	PlanDTO currentPlan;
	PhoneDTO currentPhone;
	String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
		
		customerDTO.setId(customer.getId());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setName(customer.getName());
		customerDTO.setAge(customer.getAge());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setPassword(customer.getPassword());
		
		if(customer.getPhoneId() != 0) 
		{			
			PhoneDTO phoneDTO = new PhoneDTO();
			phoneDTO.setId(customer.getId());
			customerDTO.setCurrentPhone(phoneDTO);
		}
		
		if(customer.getPlanId() != 0)
		{
			
			PlanDTO planDTO = new PlanDTO();
			planDTO.setId(customer.getId());
			customerDTO.setCurrentPlan(planDTO);
		}

		System.out.println(customerDTO);
		return customerDTO;
	}
	
	public static List<CustomerDTO> valueOf(List<Customer> customers) {
		
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		
		for(Customer customer : customers)
		{
			customerDTOs.add(CustomerDTO.valueOf(customer));
		}
		
		return customerDTOs;
	}
	
}
