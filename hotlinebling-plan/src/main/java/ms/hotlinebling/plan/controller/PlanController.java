package ms.hotlinebling.plan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ms.hotlinebling.plan.dto.PlanDTO;
import ms.hotlinebling.plan.exception.PlanException;
import ms.hotlinebling.plan.service.PlanService;

@RestController
@CrossOrigin
public class PlanController 
{
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PlanService planService;
	
	@Autowired 
	DiscoveryClient discoveryClient;
	
	/***	http://localhost:8400/plans 	***/
	@GetMapping(value = "/plans", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PlanDTO> getAllPlans() throws PlanException
	{
		try
		{
			return planService.getAllPlans();			
		}catch(PlanException exception)
		{
			LOGGER.error(exception.getMessage(), exception.getCause());
			throw new PlanException("\n\n SOMETHING WENT WRONG: \n\n" + exception.getMessage(),
					exception.getCause());
		}
	}
	
	/***	http://localhost:8400/plan/1	 
	 * @throws PlanException ***/
	@RequestMapping(value = "/plan/{plan_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PlanDTO getPlanById(@PathVariable int plan_id) throws PlanException 
	{
		try
		{			
			PlanDTO planDTO = planService.getPlanById(plan_id);
			return planDTO;
		}catch(PlanException exception)
		{
			LOGGER.error(exception.getMessage(), exception.getCause());
			throw new PlanException("\n\n SOMETHING WENT WRONG: \n\n" + exception.getMessage(),
					exception.getCause());
		}
	}
	
	/***	http://localhost:8400/plans	 ***/
	@PostMapping(value = "/plans", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PlanDTO postNewPlan(@RequestBody PlanDTO newPlan) throws PlanException
	{
		try 
		{
			PlanDTO postedPlan = planService.postNewPlan(newPlan);
			return postedPlan;
			
		}catch(PlanException exception)
		{
			LOGGER.error(exception.getMessage(), exception.getCause());
			throw new PlanException("\n\n SOMETHING WENT WRONG: \n\n" + exception.getMessage(),
					exception.getCause());
		}
		
	}
}
