package com.api.identitydocument.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DocumentType {
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;

}