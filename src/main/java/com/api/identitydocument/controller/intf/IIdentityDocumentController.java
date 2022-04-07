package com.api.identitydocument.controller.intf;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.api.identitydocument.entity.IdentityDocument;

public interface IIdentityDocumentController {
	
	public ResponseEntity<IdentityDocument> getIdentityDocument(String id);
	
	public ResponseEntity<IdentityDocument> postIdentityDocument(RequestEntity<IdentityDocument> identityDocument);
	
	public ResponseEntity<IdentityDocument> putIdentityDocument(RequestEntity<IdentityDocument> identityDocument);
	
	public HttpStatus deleteIdentityDocument(String id);
	
}
