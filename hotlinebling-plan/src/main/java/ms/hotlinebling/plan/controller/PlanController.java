package ms.hotlinebling.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
