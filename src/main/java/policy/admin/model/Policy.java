package policy.admin.model;


public class Policy {
	
	private String effectiveDate;
	private  String policyNumber;
	private String coverageAmount;
	private  String insuredPerson;
	
	
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(String coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getInsuredPerson() {
		return insuredPerson;
	}
	public void setInsuredPerson(String insuredPerson) {
		this.insuredPerson = insuredPerson;
	}
	
	@Override
	public String toString() {
		return "Policy [effectiveDate=" + effectiveDate + ",policyNumber=" + policyNumber + ",coverageAmount=" + coverageAmount + ",insuredPerson=" + insuredPerson + "]";
	}
	

}
