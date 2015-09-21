package com.company.poc.error;

public class ErrorBean {

	
	public String getStatusCode() {
		return errorCode;
	}

	public void setStatusCode(String statusCode) {
		this.errorCode = statusCode;
	}

	public String getStatusDescription() {
		return errorDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.errorDescription = statusDescription;
	}

	String errorCode;
	
	String errorDescription;
	
	
	public ErrorBean(String statusCode,String statusDescription){
		this.errorCode=statusCode;
		this.errorDescription=statusDescription;
	}
}
