package com.fuatkara.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	private final UUID id;
	
	//Name'i bos giremeyiz.
	@NotBlank
	private final String name;

	//name id gibi propertyleri json olarak gostercek
	public Person(
			@JsonProperty("id") UUID id, 
			@JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
