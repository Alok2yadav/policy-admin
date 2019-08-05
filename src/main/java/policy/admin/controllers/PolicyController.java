package policy.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import policy.admin.model.Policy;
import policy.admin.service.PolicyService;

@Controller
public class PolicyController {

	@Autowired
	PolicyService policyService;

	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public ModelAndView showPolicyDetails(@RequestParam("id") String id) {

		Policy policy = policyService.getPolicyById(id);
		ModelAndView model = new ModelAndView("policy");
		model.addObject("policy", policy);

		return model;
	}

	@RequestMapping(value = "/addNewPolicy", method = RequestMethod.GET)
	public ModelAndView processRequest() {
		ModelAndView mv = new ModelAndView("policyForm");
		Policy newPolicy = new Policy();
		mv.addObject("policy_form", newPolicy);
		return mv;
	}

	@RequestMapping("/")
	public ModelAndView getPolicies() {
		List<Policy> policies = policyService.getAllPolicies();
		ModelAndView model = new ModelAndView("getPolicies");
		model.addObject("policies", policies);
		return model;
	}

	@RequestMapping("/deletePolicy")
	public ModelAndView deletePolicy(@RequestParam("id") String id) {
		int i = policyService.deletePolicy(id);
		return getPolicies();
	}

	@RequestMapping("/updatePolicy")
	public ModelAndView updatePolicy(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("policyForm");
		Policy getPolicy = policyService.getPolicyById(id);
		mv.addObject("policy_form", getPolicy);
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("policy_form") Policy policy) {

		Policy getPolicy = policyService.getPolicyById(policy.getPolicyNumber());
		if (getPolicy != null) {
			policyService.updatePolicy(policy);
		} else {
			policyService.insertPolicy(policy);
		}
		return getPolicies();
	}

	@RequestMapping("/deleteAllPolicy")
	public ModelAndView deleteAllPolicy() {
		policyService.deleteAllPolicy();
		return getPolicies();
	}
}