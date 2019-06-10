package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Activity;

public class ActivityRepositoryStub implements ActivityRepository {

	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(5);
		
		Activity activity2 = new Activity();
		activity2.setDescription("Running");
		activity2.setDuration(10);
		
		activities.add(activity1);
		activities.add(activity2);
		
		return activities;
	}
}
