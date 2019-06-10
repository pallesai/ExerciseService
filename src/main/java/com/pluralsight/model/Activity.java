package com.pluralsight.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement
public class Activity {
	
	private @NonNull String description;
	private @NonNull int duration;
}
