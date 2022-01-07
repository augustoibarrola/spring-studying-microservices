package ms.hotlinebling.customer.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ms.hotlinebling.customer.entity.Customer;

public class CustomerDTO 
{
	Integer id;
	String firstName;
	String lastName;
	String middleName;
	Integer age;
	Long phoneNumber;
	String eMail;
	String address;
	PlanDTO currentPlan;
	PhoneDTO currentPhone;
	String password;
	Integer ssn;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return this.eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PlanDTO getCurrentPlan() {
		return this.currentPlan;
	}

	public void setCurrentPlan(PlanDTO currentPlan) {
		this.currentPlan = currentPlan;
	}

	public PhoneDTO getCurrentPhone() {
		return this.currentPhone;
	}

	public void setCurrentPhone(PhoneDTO currentPhone) {
		this.currentPhone = currentPhone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSsn() {
		return this.ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public static CustomerDTO valueOf(Customer customer)
	{
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setId(customer.getId());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setMiddleName(customer.getMiddleName());
		customerDTO.setLastName(customer.getLastName());
		
		customerDTO.setAge(customer.getAge());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		
		customerDTO.seteMail(customer.geteMail());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setPassword(customer.getPassword());
		customerDTO.setSsn(customer.getSsn());
//		
//		if(customer.getPhoneId() != 0) 
//		{			
//			PhoneDTO phoneDTO = new PhoneDTO();
//			phoneDTO.setId(customer.getId());
//			customerDTO.setCurrentPhone(phoneDTO);
//		}
//		
//		if(customer.getPlanId() != 0)
//		{
//			
//			PlanDTO planDTO = new PlanDTO();
//			planDTO.setId(customer.getId());
//			customerDTO.setCurrentPlan(planDTO);
//		}

		return customerDTO;
	}
	
	public static CustomerDTO valueOf(Optional<Customer> optionalCustomer)
	{
		Customer customer = optionalCustomer.get();
		
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setId(customer.getId());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setMiddleName(customer.getMiddleName());
		customerDTO.setLastName(customer.getLastName());
		
		customerDTO.setAge(customer.getAge());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		
		customerDTO.seteMail(customer.geteMail());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setPassword(customer.getPassword());
		customerDTO.setSsn(customer.getSsn());
//		
//		if(customer.getPhoneId() != 0) 
//		{			
//			PhoneDTO phoneDTO = new PhoneDTO();
//			phoneDTO.setId(customer.getId());
//			customerDTO.setCurrentPhone(phoneDTO);
//		}
//		
//		if(customer.getPlanId() != 0)
//		{
//			
//			PlanDTO planDTO = new PlanDTO();
//			planDTO.setId(customer.getId());
//			customerDTO.setCurrentPlan(planDTO);
//		}

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
