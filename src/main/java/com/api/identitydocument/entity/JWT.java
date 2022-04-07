package com.api.identitydocument.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Document("jwt")
@Data
public class JWT implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("client")
	private Client client;
	
	@JsonProperty("refreshToken")
	private String refreshToken;
	
	@JsonProperty("creationDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", locale = "es_ES", timezone = "Europe/Madrid")
	private Date creationDate;
	
	@JsonProperty("expirationDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", locale = "es_ES", timezone = "Europe/Madrid")
	private Date expirationDate;
	
	@JsonProperty("openSessions")
	private Long openSessions;
	
}
