package com.poc.application;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.poc.resource.EnrollmentResource;


public class EnrollmentApplication extends Application<EnrollmentConfiguration> {
	    public static void main(String[] args) throws Exception {
	        new EnrollmentApplication().run(args);
	    }

	    @Override
	    public String getName() {
	        return "EnrollmentApplication";
	    }

	    @Override
	    public void initialize(Bootstrap<EnrollmentConfiguration> bootstrap) {
	        // nothing to do yet
	    }

	    @Override
	    public void run(EnrollmentConfiguration configuration,
	                    Environment environment) {
	        final EnrollmentResource resource = new EnrollmentResource( configuration.getTemplate());
	        environment.jersey().register(resource);
	    }
	
	
}
