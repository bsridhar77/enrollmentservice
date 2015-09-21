/* test*/
package com.poc.model;

public class Enrollment {

	
	String enrollmentId;
	
	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getEnrollmentType() {
		return enrollmentType;
	}

	public void setEnrollmentType(String enrollmentType) {
		this.enrollmentType = enrollmentType;
	}

	public String getEnrollmentAmount() {
		return enrollmentAmount;
	}

	public void setEnrollmentAmount(String enrollmentAmount) {
		this.enrollmentAmount = enrollmentAmount;
	}

	String enrollmentType;
	
	String enrollmentAmount;
	

	String agentId;
	
	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public Enrollment(){
		
	}

	public Enrollment(String enrollmentId,String enrollmentType, String enrollmentAmount,String agentId){
		
		this.enrollmentId=enrollmentId;
		this.enrollmentType=enrollmentType;
		this.enrollmentAmount=enrollmentAmount;
		this.agentId=agentId;
	}

	
	
}
