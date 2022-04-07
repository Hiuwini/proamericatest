package com.api.identitydocument.service.intf;

import com.api.identitydocument.entity.Client;
import com.api.identitydocument.generics.entities.AuthData;

public interface IAuthDataService {
	
	public AuthData auth(Client client);

}
