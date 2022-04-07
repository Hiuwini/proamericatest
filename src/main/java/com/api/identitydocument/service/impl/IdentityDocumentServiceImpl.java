package com.api.identitydocument.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.identitydocument.entity.IdentityDocument;
import com.api.identitydocument.exception.GenericException;
import com.api.identitydocument.exception.NotNullable;
import com.api.identitydocument.exception.RequiredField;
import com.api.identitydocument.repository.intf.IIdentityDocumentRepository;
import com.api.identitydocument.service.intf.IIdentityDocumentService;

@Service
public class IdentityDocumentServiceImpl implements IIdentityDocumentService {
	
	@Autowired
	private IIdentityDocumentRepository idRepoIntf;

	@Override
	public IdentityDocument getIdentityDocument(String id) {
		try {
			if(Objects.isNull(id)) throw new NotNullable("id");
			return idRepoIntf.findById(id).get();
		} catch (NotNullable e) { 
			throw new RequiredField(e.getMessage(), IdentityDocument.class.getName());
		}
	}

	@Override
	public IdentityDocument postIdentityDocument(IdentityDocument identityDocument) {
		try {
			if(Objects.isNull(identityDocument.getDocumentType())) throw new NotNullable("documentType");
			if(Objects.isNull(identityDocument.getNumber())) throw new NotNullable("number");
			return idRepoIntf.insert(identityDocument);
		} catch (NotNullable e) {
			throw new RequiredField(e.getMessage(), IdentityDocument.class.getName());
		} catch (GenericException e) {
			throw new GenericException("IdentityDocumentServiceImpl", "postIdentityDocument", e.getMessage());
		} 
	}

	@Override
	public IdentityDocument putIdentityDocument(IdentityDocument identityDocument) {
		try {
			if(Objects.isNull(identityDocument.getId())) throw new NotNullable("id");
			if(Objects.isNull(identityDocument.getDocumentType())) throw new NotNullable("documentType");
			if(Objects.isNull(identityDocument.getNumber())) throw new NotNullable("number");
			return idRepoIntf.save(identityDocument);
		} catch (NotNullable e) {
			throw new RequiredField(e.getMessage(), IdentityDocument.class.getName());
		} catch (GenericException e) {
			throw new GenericException("IdentityDocumentServiceImpl", "postIdentityDocument", e.getMessage());
		} 
	}

	@Override
	public boolean deleteIdentityDocument(String id) {
		try {
			if(Objects.isNull(id)) throw new NotNullable("id");
			IdentityDocument identityDoc = idRepoIntf.findById(id).get();
			idRepoIntf.delete(identityDoc);
			return true;
		} catch (NotNullable e) {
			throw new RequiredField(e.getMessage(), IdentityDocument.class.getName());
		} catch (GenericException e) {
			throw new GenericException("IdentityDocumentServiceImpl", "postIdentityDocument", e.getMessage());
		} 
	}

}
