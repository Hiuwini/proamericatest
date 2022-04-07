package com.api.identitydocument.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Document("client")
@Data
public class Client {

	@Id
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("client")
	private String client;
	
	@JsonProperty("key")
	private String key;
	
}
