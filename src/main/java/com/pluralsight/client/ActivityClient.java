package com.pluralsight.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.pluralsight.model.Activity;

public class ActivityClient {

	private Client client;
	
	public ActivityClient() {
		client = ClientBuilder.newClient();
	}
	
	public Activity get(String id) {
		WebTarget target= client.target("http://localhost:8080/ExerciseService/webapi/");
		
		Activity activity = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Activity.class);
		
		return activity;
	}
	
	public List<Activity> get() {
		WebTarget target= client.target("http://localhost:8080/ExerciseService/webapi/");
		
		List<Activity> responses = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {});
		
		return responses;
	}
}
