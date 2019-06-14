package com.pluralsight.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivitySearch {

	private int durationFrom;
	private int durationTo;
	
	private List<String> descriptions;
	
}
