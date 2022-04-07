package com.api.identitydocument.service.impl;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.identitydocument.entity.Client;
import com.api.identitydocument.entity.JWT;
import com.api.identitydocument.exception.GenericException;
import com.api.identitydocument.exception.NotNullable;
import com.api.identitydocument.exception.RequiredField;
import com.api.identitydocument.exception.ResourceNotFoundException;
import com.api.identitydocument.generics.entities.AuthData;
import com.api.identitydocument.generics.types.IAuthorizationTypes;
import com.api.identitydocument.generics.types.ISetupTypes;
import com.api.identitydocument.repository.intf.IJWTRepository;
import com.api.identitydocument.repository.intf.ISetupRepository;
import com.api.identitydocument.service.intf.IAuthDataService;

import io.jsonwebtoken.Jwts;

@Service
public class AuthDataServiceImpl implements IAuthDataService{
	
	@Autowired
	private IJWTRepository jwtRepo;
	
	@Autowired
	private ISetupRepository setupRepo;

	@Override
	public AuthData auth(Client client) {
		try {
			if(Objects.isNull(client.getClient())) throw new NotNullable("client");
			if(Objects.isNull(client.getKey())) throw new NotNullable("key");
			AuthData ad = new AuthData();
			ad = (getAuthData(client, jwtRepo.findByClientAndKey(client.getClient(), client.getKey()), true));
			return ad;
		} catch (NotNullable e) {
			throw new RequiredField(e.getMessage(), Client.class.getName());
		} catch (ResourceNotFoundException e) {
			throw new GenericException("user", "user", e.getMessage());
		}
	}
	
	private AuthData getAuthData(Client client, JWT refreshToken, boolean login) {
		AuthData authD = new AuthData();
		String uuid = UUID.randomUUID().toString();
		Date issuedAt = new Date(System.currentTimeMillis());
		Date expiration = new Date(System.currentTimeMillis() + IAuthorizationTypes.lifeTimeToken * 1000);
		authD.setTokenType(IAuthorizationTypes.bearerType);
		authD.setToken(Jwts
						.builder()
						.setSubject(client.getClient())
						.setId(uuid)
						.setIssuedAt(issuedAt)
						.setExpiration(expiration)
						.claim("client", client.getClient())
						.claim("id", client.getId())
						.claim("iss", "PROAMERICA")
						.signWith(IAuthorizationTypes.signatureAlgorithm, setupRepo.findItemByKeyName(ISetupTypes.jwt_keyName).getKeyValue().getBytes())
						.compact());
		authD.setExpirationTime(expiration);
		authD.setCreationTime(issuedAt);
		if(refreshToken == null) {
			authD.setRefreshToken(createRefreshToken(client).getRefreshToken());
		} else {
			authD.setRefreshToken(refreshToken.getRefreshToken());
			if(login)
				jwtRepo.save(refreshToken);
		}
		return authD;
	}
	
	private JWT createRefreshToken(Client client) {
		Date issuedAt = new Date(System.currentTimeMillis());
		Date expiration = new Date(System.currentTimeMillis() + IAuthorizationTypes.lifeTimeRefreshToken * 1000);
		String refreshToken = Jwts
				.builder()
				.setIssuedAt(issuedAt)
				.claim("user", client.getClient())
				.claim("iss", "PROAMERICA")
				.signWith(IAuthorizationTypes.signatureAlgorithmRefreshToken, setupRepo.findItemByKeyName(ISetupTypes.jwt_keyName).getKeyValue().getBytes())
				.compact();
		JWT jwt = new JWT();
		jwt.setRefreshToken(refreshToken);
		jwt.setExpirationDate(expiration);
		jwt.setClient(client);
		return jwtRepo.save(jwt);
	}

}
