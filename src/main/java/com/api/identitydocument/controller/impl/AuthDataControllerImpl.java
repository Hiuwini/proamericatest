package com.api.identitydocument.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.identitydocument.controller.intf.IAuthDataController;
import com.api.identitydocument.entity.Client;
import com.api.identitydocument.generics.entities.AuthData;
import com.api.identitydocument.service.intf.IAuthDataService;

@RestController
@RequestMapping("/auth")
public class AuthDataControllerImpl implements IAuthDataController {
	
	@Autowired
	private IAuthDataService adServiceIntf;
	
	@Override
	@PostMapping
	public ResponseEntity<AuthData> getJwt(RequestEntity<Client> client) {
		return new ResponseEntity<AuthData>(adServiceIntf.auth(client.getBody()), HttpStatus.OK);
	}

}
