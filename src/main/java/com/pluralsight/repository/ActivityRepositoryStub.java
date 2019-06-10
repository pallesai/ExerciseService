package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setId("1234");
		activity1.setDescription("Swimming");
		activity1.setDuration(5);
		
		Activity activity2 = new Activity();
		activity1.setId("5678");
		activity2.setDescription("Running");
		activity2.setDuration(10);
		
		activities.add(activity1);
		activities.add(activity2);
		
		return activities;
	}

	@Override
	public Activity findActivity(String activityId) {
		Activity activity1 = new Activity();
		User user = new User();
		
		user.setName("Krishna");
		user.setId("12345678");
		
		activity1.setId("1234");
		activity1.setDescription("Swimming");
		activity1.setDuration(5);
		activity1.setUser(user);
		
		
		
		return activity1;
	}
}
