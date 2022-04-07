package com.api.identitydocument.generics.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(content = Include.NON_EMPTY)
public class AuthData {

	@JsonProperty("token")
	private String token;
	
	@JsonProperty("refreshToken")
	private String refreshToken;
	
	@JsonProperty("tokenType")
	private String tokenType;
		
	@JsonProperty("expirationTime")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER, locale = "es_ES", timezone = "Europe/Madrid")
	private Date expirationTime;
	
	@JsonProperty("creationTime")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER, locale = "es_ES", timezone = "Europe/Madrid")
	private Date creationTime;
	
}
