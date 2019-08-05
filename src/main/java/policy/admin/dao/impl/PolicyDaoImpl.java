package policy.admin.dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import policy.admin.dao.PolicyDao;
import policy.admin.model.Policy;
import policy.admin.dao.impl.PolicyRowMapper;


@Repository
public class PolicyDaoImpl extends JdbcDaoSupport implements PolicyDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertPolicy(Policy policy) {
		String sql = "INSERT INTO policy " + "(effectiveDate, policyNumber, coverageAmount, insuredPerson) VALUES (?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[] { policy.getEffectiveDate(), policy.getPolicyNumber(), policy.getCoverageAmount(), policy.getInsuredPerson() });

	}

	@Override
	public List<Policy> getAllPolicies() {
		String sql = "SELECT * FROM policy";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Policy> result = new ArrayList<Policy>();
		for(Map<String, Object> row:rows){
			Policy policy = new Policy();
			policy.setEffectiveDate((String)row.get("effectiveDate"));
			policy.setPolicyNumber((String)row.get("policyNumber"));
			policy.setCoverageAmount((String)row.get("coverageAmount"));
			policy.setInsuredPerson((String)row.get("insuredPerson"));		
			result.add(policy);
		}		
		return result;
	}
	
	@Override
	public Policy getPolicyById(String policyNumber) {	
		
		String sql = "SELECT * FROM policies.policy WHERE policyNumber = ?";
		try {
		@SuppressWarnings("unchecked")
		Policy policy = (Policy)getJdbcTemplate().queryForObject(sql, new Object[] { policyNumber }, new BeanPropertyRowMapper(Policy.class));
		return policy;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}		 
	}

	@Override
	public int deletePolicy(String policyNumber) {
		
		String sql = "Delete FROM policies.policy WHERE policyNumber = ?";		
		int i = getJdbcTemplate().update(sql, new Object[] { policyNumber });		 
		return i;
	}

	@Override
	public void updatePolicy(Policy policy) {
		
		String sql = "Update policies.policy SET effectiveDate=?, coverageAmount=?, insuredPerson=? where policyNumber=?";	
		getJdbcTemplate().update(sql, new Object[] { policy.getEffectiveDate(), policy.getCoverageAmount(), policy.getInsuredPerson(),policy.getPolicyNumber() });
		
	}

	@Override
	public void deleteAllPolicy() {
		String sql = "Delete FROM policies.policy";
		getJdbcTemplate().update(sql);
		
	}

	

}