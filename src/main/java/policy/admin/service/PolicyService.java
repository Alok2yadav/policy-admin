package policy.admin.service;

import java.util.List;

import policy.admin.model.Policy;

public interface PolicyService {

	void insertPolicy(Policy policy);
	List<Policy> getAllPolicies();
	Policy getPolicyById(String id);
	int deletePolicy(String id);
	void updatePolicy(Policy policy);
	void deleteAllPolicy();
}
