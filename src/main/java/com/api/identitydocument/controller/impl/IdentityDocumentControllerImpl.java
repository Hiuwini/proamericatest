package com.api.identitydocument.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.identitydocument.controller.intf.IIdentityDocumentController;
import com.api.identitydocument.entity.IdentityDocument;
import com.api.identitydocument.service.intf.IIdentityDocumentService;

@RestController
@RequestMapping("/identitydocument")
public class IdentityDocumentControllerImpl implements IIdentityDocumentController {
	
	@Autowired
	private IIdentityDocumentService idServiceIntf;

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<IdentityDocument> getIdentityDocument(@PathVariable String id) {
		IdentityDocument identityDoc = idServiceIntf.getIdentityDocument(id);
		return new ResponseEntity<IdentityDocument>(identityDoc, HttpStatus.OK);
	}

	@Override
	@PostMapping
	public ResponseEntity<IdentityDocument> postIdentityDocument(RequestEntity<IdentityDocument> identityDocument) {
		IdentityDocument identityDoc = idServiceIntf.postIdentityDocument(identityDocument.getBody());
		return new ResponseEntity<IdentityDocument>(identityDoc, HttpStatus.CREATED);
	}

	@Override
	@PutMapping
	public ResponseEntity<IdentityDocument> putIdentityDocument(RequestEntity<IdentityDocument> identityDocument) {
		IdentityDocument identityDoc = idServiceIntf.putIdentityDocument(identityDocument.getBody());
		return new ResponseEntity<IdentityDocument>(identityDoc, HttpStatus.ACCEPTED);
	}

	@Override
	@DeleteMapping("/{id}")
	public HttpStatus deleteIdentityDocument(@PathVariable String id) {
		if(idServiceIntf.deleteIdentityDocument(id))
			return HttpStatus.OK;
		else
			return HttpStatus.BAD_REQUEST;
		
	}

}
