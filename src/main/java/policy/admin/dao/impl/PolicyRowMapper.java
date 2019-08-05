package policy.admin.dao.impl;

import policy.admin.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PolicyRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Policy policy = new Policy();
		policy.setCoverageAmount(rs.getString("coverageAmount"));
		policy.setEffectiveDate((rs.getString("effectiveDate")));
		policy.setInsuredPerson((rs.getString("insuredPerson")));
		
		return policy;
	}
	
}