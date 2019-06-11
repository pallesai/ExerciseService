package com.pluralsight.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
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
}
