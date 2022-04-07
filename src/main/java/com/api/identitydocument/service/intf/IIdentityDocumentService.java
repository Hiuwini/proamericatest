package com.api.identitydocument.service.intf;

import com.api.identitydocument.entity.IdentityDocument;

public interface IIdentityDocumentService {
	
	public IdentityDocument getIdentityDocument(String id);
	
	public IdentityDocument postIdentityDocument(IdentityDocument identityDocument);
	
	public IdentityDocument putIdentityDocument(IdentityDocument identityDocument);
	
	public boolean deleteIdentityDocument(String id);	

}
