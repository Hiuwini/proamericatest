package com.api.identitydocument.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Document("setup")
@Data
public class Setup {
	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("keyName")
	private String keyName;
	
	@JsonProperty("keyValue")
	private String keyValue;

}
