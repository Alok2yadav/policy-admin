package policy.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import policy.admin.dao.PolicyDao;
import policy.admin.model.Policy;
import policy.admin.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService{

	@Autowired
	PolicyDao policydao;

	@Override
	public void insertPolicy(Policy policy) {
		policydao.insertPolicy(policy);
		
	}

	@Override
	public List<Policy> getAllPolicies() {		
		return policydao.getAllPolicies();
	}
	
	@Override
	public Policy getPolicyById(String id) {
		return policydao.getPolicyById(id);
	}

	@Override
	public int deletePolicy(String id) {
		return policydao.deletePolicy(id);
	}

	@Override
	public void updatePolicy(Policy policy) {
		 policydao.updatePolicy(policy);
		
	}

	@Override
	public void deleteAllPolicy() {
		policydao.deleteAllPolicy();
		
	}

	

}