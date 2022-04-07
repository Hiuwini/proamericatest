package com.api.identitydocument.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Document("identityDocument")
@Data
public class IdentityDocument {

	
	@Id
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("number")
	private String number;

	@JsonProperty("expireDate")
	private String expireDate;
	
	@JsonProperty("emissionDate")
	private Date emissionDate;
	
	@JsonProperty("documentType")
	private DocumentType documentType;
	
	
}
