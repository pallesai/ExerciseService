package com.pluralsight;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

@Path("search/activities")
public class ActivitySearchResource {
	
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchActivities(@QueryParam(value="description") List<String> descriptions) {
		System.out.println(descriptions);
		
		List<Activity> acitivities = activityRepository.findByDescriptions(descriptions);
		
		if (acitivities == null || acitivities.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(new GenericEntity<List<Activity>>(acitivities) {}).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchActivities(ActivitySearch activitySearch) {
		
		System.out.println(activitySearch.getDescriptions() + ", " + activitySearch.getDurationFrom());
		
		List<Activity> acitivities = activityRepository.findByConstraints(activitySearch);
		
		if (acitivities == null || acitivities.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(new GenericEntity<List<Activity>>(acitivities) {}).build();
	}
}
