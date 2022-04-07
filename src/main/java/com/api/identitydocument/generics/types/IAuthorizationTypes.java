package com.api.identitydocument.generics.types;

import io.jsonwebtoken.SignatureAlgorithm;

public interface IAuthorizationTypes {

	public static final String bearerType = "Bearer";
	
	public static final String realm = "APIPROAMERICA_REALM";
	
	public static final String header = "Authorization";
	
	public static final long lifeTimeToken = 3 * 60 * 60;
	
	public static final long lifeTimeRefreshToken = 8 * 60 * 60;
	
	public static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
	
	public static final SignatureAlgorithm signatureAlgorithmRefreshToken = SignatureAlgorithm.HS256;
	
}
