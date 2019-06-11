package com.pluralsight.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.pluralsight.model.Activity;

public class ActivityClientTest {

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		
		Activity activity = client.get("1234");
		
		assertNotNull(activity);
	}

}
