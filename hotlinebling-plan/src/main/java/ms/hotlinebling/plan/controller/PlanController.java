package ms.hotlinebling.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ms.hotlinebling.plan.dto.PlanDTO;
import ms.hotlinebling.plan.service.PlanService;

@RestController
@CrossOrigin
public class PlanController 
{
	@Autowired
	PlanService planService;
	
	@GetMapping(value = "/plans", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlanDTO> getAllPlans()
	{
		return planService.getAllPlans();
	}
	/*
	 * http://localhost:8400/plans
	 */
	
	@RequestMapping(value = "/plan/{plan_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PlanDTO getPlanById(@PathVariable int plan_id)
	{
		PlanDTO planDTO = planService.getById(plan_id);
		return planDTO;
	}
	/*
	 * http://localhost:8400/plan/1
	 */
}
