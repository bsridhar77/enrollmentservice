package com.poc.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.company.poc.error.ErrorBean;
import com.poc.model.Enrollment;




@Path("/enrollment")
@Produces(MediaType.APPLICATION_JSON)
public class EnrollmentResource {
	
	public final static Map<String, Enrollment> enrollments = new TreeMap<String, Enrollment>();

	public static final String SENIOR_GROUP="SeniorGroup";
	
	public static final String SMALL_GROUP="SmallGroup";
	
	public static final String MEDIUM_GROUP="MediumGroup";
	
	public static final String LARGE_GROUP="LargeGroup";
	
	
	static {
		
		enrollments.put("1", new Enrollment("1", SENIOR_GROUP,"2500","123"));
		enrollments.put("2", new Enrollment("2", SMALL_GROUP,"1200","123"));
		enrollments.put("3", new Enrollment("3", MEDIUM_GROUP,"455","123"));
		enrollments.put("4", new Enrollment("4", LARGE_GROUP,"455","123"));

		enrollments.put("5", new Enrollment("5", SENIOR_GROUP,"2500","456"));
		enrollments.put("6", new Enrollment("6", SMALL_GROUP,"455","456"));
		enrollments.put("7", new Enrollment("7", MEDIUM_GROUP,"455","456"));
		
		enrollments.put("8", new Enrollment("8", SENIOR_GROUP,"455","789"));
		enrollments.put("9", new Enrollment("9", MEDIUM_GROUP,"455","789"));
		
	}


	 private final String template;
	 
	 public EnrollmentResource(String template) {
	        this.template = template;
	    }
	 
    @GET
    @Path("/{id}")
    public Response getEnrollmentDetails(@PathParam("id") String enrollmentId) {
    	
    	System.out.println("Received enrollmentId: " +enrollmentId);
    	
    	if(enrollments.containsKey(enrollmentId)){
    		return Response.status(Response.Status.OK).entity(enrollments.get(enrollmentId)).build();
    	}else{
    		return 	Response.status(Response.Status.NOT_FOUND).entity(new ErrorBean("001","Invalid Enrollment!")).build();
    				
    	}
		
    }

    

    
    @GET
    public Collection<Enrollment> listEnrollments() {
    	return enrollments.values();	 
    }
	
    
    
    @GET
    @Path("/all/agent/{id}")
    public   Collection<Enrollment> getEnrollmentsById(@PathParam("id") String agentId) {
    	
    	return getEnrollmentsForAgentId(agentId);
    	
    }
    
    
    private Collection<Enrollment>  getEnrollmentsForAgentId(String agentId) {

    	 List<Enrollment> agentEnrollments = new ArrayList<Enrollment>();
    	 
    	//loop a Map
    		for (Map.Entry<String, Enrollment> entry : enrollments.entrySet()) {
    			
    			if(agentId.equalsIgnoreCase(entry.getValue().getAgentId())){
    				agentEnrollments.add(entry.getValue());
    			}
    		} 
    	 return agentEnrollments;
	}

	@GET
	@Path("/sg/agent/{id}")
    public  Collection<Enrollment> getSmallGroupsByAgentId(@PathParam("id") String agentId) {
    
		return getSmallGroupsEnrollmentsForAgentId(agentId,SMALL_GROUP);
	}
    
	
	
	@GET
	@Path("/med/agent/{id}")
    public Collection<Enrollment> getMediumGroupEnrollmentsByAgentId(@PathParam("id") String agentId) {
		return getMediumGroupsEnrollmentsForAgentId(agentId,MEDIUM_GROUP); 
    }
    
    @GET
    @Path("/agent/{id}")
    public Collection<Enrollment> getEnrollmentsByEnrollmentTypeAndAgentId(@QueryParam("type") String type,@PathParam("id") String agentId) {
    	return getByType(agentId,type); 
    }
	
    
    private Collection<Enrollment> getSmallGroupsEnrollmentsForAgentId(String agentId,String type) {
	
    	return getByType(agentId,type);
	}

    private Collection<Enrollment>getMediumGroupsEnrollmentsForAgentId(String agentId,String type) {
    	
    	return getByType(agentId,type);
	}
    

    private  Collection<Enrollment> getByType(String agentId, String type){
    	
    	 List<Enrollment> agentEnrollments = new ArrayList<Enrollment>();
    	 
      	//loop a Map
      		for (Map.Entry<String, Enrollment> entry : enrollments.entrySet()) {
      			
      			if(agentId.equalsIgnoreCase(entry.getValue().getAgentId()) && entry.getValue().getEnrollmentType().equalsIgnoreCase(type)){
      				agentEnrollments.add(entry.getValue());	
      			}
      		} 
      		
      		return agentEnrollments;
    }
    
	
    
}
