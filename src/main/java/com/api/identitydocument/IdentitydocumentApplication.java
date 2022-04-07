package com.api.identitydocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.api.identitydocument.repository.intf.IIdentityDocumentRepository;
import com.api.identitydocument.repository.intf.ISetupRepository;

@SpringBootApplication
@EnableMongoRepositories
public class IdentitydocumentApplication {

	@Autowired
	IIdentityDocumentRepository identityDocumentRepository;
	
	@Autowired
	ISetupRepository iSetupRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(IdentitydocumentApplication.class, args);
	}

}
