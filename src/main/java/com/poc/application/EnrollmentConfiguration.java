package com.poc.application;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class EnrollmentConfiguration extends Configuration {

		@NotEmpty
	    private String template;
	    @JsonProperty
	    public String getTemplate() {
	        return template;
	    }

	    @JsonProperty
	    public void setTemplate(String template) {
	        this.template = template;
	    }
	
}
