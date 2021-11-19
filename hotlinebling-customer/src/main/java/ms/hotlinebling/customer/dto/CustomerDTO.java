package ms.hotlinebling.customer.dto;

import java.util.ArrayList;
import java.util.List;

import ms.hotlinebling.customer.entity.Customer;

public class CustomerDTO 
{
	int id;
	String firstName;
	String lastName;
	String middleName;
	int age;
	long phoneNumber;
	String eMail;
	String address;
	PlanDTO currentPlan;
	PhoneDTO currentPhone;
	String password;
	int ssn;

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

	public PlanDTO getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan(PlanDTO currentPlan) {
		this.currentPlan = currentPlan;
	}

	public PhoneDTO getCurrentPhone() {
		return currentPhone;
	}

	public void setCurrentPhone(PhoneDTO currentPhone) {
		this.currentPhone = currentPhone;
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

	public static CustomerDTO valueOf(Customer customer)
	{
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setId(customer.getId());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setFirstName(customer.getFirstName());
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
