package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity activity);

	Activity update(Activity activity);

	void delete(String activityId);

	List<Activity> findByDescriptions(List<String> descriptions);

	List<Activity> findByConstraints(ActivitySearch activitySearch);

}