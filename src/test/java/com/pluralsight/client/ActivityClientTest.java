package com.pluralsight.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;

public class ActivityClientTest {

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		
		Activity activity = client.get("1234");
		
		assertNotNull(activity);
	}
	
	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		
		List<Activity> responses = client.get();
		
		assertNotNull(responses);
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithBadRequest() {
		ActivityClient client = new ActivityClient();
		client.get("34");
	}
	
	@Test
	public void testCreate() {
		ActivityClient client = new ActivityClient();
		
		Activity activity = new Activity();
		activity.setDescription("Jogging");
		activity.setDuration(90);
		
		activity = client.create(activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testPut() {
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		
		activity.setId("4567");
		activity.setDescription("Running activity description");
		activity.setDuration(10);
		
		activity = client.update(activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testDelete() {
		ActivityClient client = new ActivityClient();
		
		client.delete("1234");
	}
	
	@Test
	public void testSearch() {
		ActivitySearchClient client = new ActivitySearchClient();
		
		String param = "descriptions";
		List<String> searchValues = new ArrayList<String>();
		
		searchValues.add("Swimming");
		searchValues.add("Running");
		searchValues.add("Jogging");
		
		List<Activity> activities = client.search(param, searchValues);
		System.out.println(activities);
		
		assertNotNull(activities);
	}
	
	@Test
	public void testSearchObject() {
		ActivitySearchClient client = new ActivitySearchClient();
		ActivitySearch activitySearch = new ActivitySearch();
		List<String> searchValues = new ArrayList<String>();
		
		searchValues.add("Biking");
		searchValues.add("Running");
		searchValues.add("Jogging");
		
		activitySearch.setDescriptions(searchValues);
		activitySearch.setDurationFrom(30);
		activitySearch.setDurationTo(50);
		
		
		List<Activity> activities = client.search(activitySearch);
		
		System.out.println(activities);
		
		assertNotNull(activities);
	}

}
