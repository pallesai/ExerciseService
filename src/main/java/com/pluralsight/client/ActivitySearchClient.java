package com.pluralsight.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;

public class ActivitySearchClient {
	
	private Client client;
	
	public ActivitySearchClient() {
		client = ClientBuilder.newClient();
	}
	
	public List<Activity> search(String param, List<String> searchValues) {
		URI uri = UriBuilder.fromUri("http://localhost:8080/ExerciseService/webapi")
				.path("search/activities")
				.queryParam(param, searchValues)
				.build();
		WebTarget target= client.target(uri);
		List<Activity> responses = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>> () {});
		return responses;
	}

	public List<Activity> search(ActivitySearch activitySearch) {
		
		URI uri = UriBuilder.fromUri("http://localhost:8080/ExerciseService/webapi")
				.path("search/activities")
				.build();
		WebTarget target= client.target(uri);
		
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activitySearch, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : there is an error on the server");
		}
		
		return response.readEntity(new GenericType<List<Activity>>() {});
	}
}
