package com.api.identitydocument.controller.intf;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.api.identitydocument.entity.Client;
import com.api.identitydocument.generics.entities.AuthData;

public interface IAuthDataController {

	public ResponseEntity<AuthData> getJwt(RequestEntity<Client> client);
	
	
}
