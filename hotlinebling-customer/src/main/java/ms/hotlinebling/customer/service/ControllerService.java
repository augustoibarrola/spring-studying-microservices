package ms.hotlinebling.customer.service;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import ms.hotlinebling.customer.dto.CustomerDTO;
import ms.hotlinebling.customer.dto.PhoneDTO;
import ms.hotlinebling.customer.dto.PlanDTO;
import ms.hotlinebling.customer.exception.ServiceDiscoveryException;

@Service(value="controllerService")
@Transactional
public class ControllerService 
{
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public void setCustomerPhone(CustomerDTO customerDTO) throws ServiceDiscoveryException
	{
		PhoneDTO phoneDTO = new RestTemplate()
				.getForObject(getPhoneURI() + "/phone/" + customerDTO.getCurrentPhone().getId(), PhoneDTO.class);

		customerDTO.setCurrentPhone(phoneDTO);
	}

	public void setCustomerPlan(CustomerDTO customerDTO) throws ServiceDiscoveryException 
	{
		PlanDTO planDTO = new RestTemplate()
				.getForObject(getPlanURI() + "/plan/" + customerDTO.getCurrentPlan().getId(), PlanDTO.class);

		customerDTO.setCurrentPlan(planDTO);
	}
	
	public void postNewCustomerPlan(CustomerDTO customerDTO) throws ServiceDiscoveryException 
	{
		PlanDTO planDTO = new RestTemplate().postForObject(getPlanURI() + "/plans", customerDTO.getCurrentPlan(),
				PlanDTO.class);
		customerDTO.setCurrentPlan(planDTO);

	}

	public void postNewCustomerPhone(CustomerDTO customerDTO) throws ServiceDiscoveryException 
	{
		PhoneDTO phoneDTO = new RestTemplate().postForObject(getPhoneURI() + "/phones", customerDTO.getCurrentPhone(),
				PhoneDTO.class);
		customerDTO.setCurrentPhone(phoneDTO);

	}

	/*
	 * @return uri for phone microservice instance
	 */
	public URI getPhoneURI() 
	{
		List<ServiceInstance> phoneInstances = discoveryClient.getInstances("PhoneMS");
		ServiceInstance phoneInstance = phoneInstances.get(0);
		return phoneInstance.getUri();
	}

	/*
	 * @return uri for plan microservice instance
	 */
	public URI getPlanURI() 
	{
		List<ServiceInstance> planInstances = discoveryClient.getInstances("PlanMS");
		ServiceInstance planInstance = planInstances.get(0);
		return planInstance.getUri();
	}

}
