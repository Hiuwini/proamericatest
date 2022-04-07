package com.api.identitydocument.repository.intf;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.identitydocument.entity.IdentityDocument;

public interface IIdentityDocumentRepository extends MongoRepository<IdentityDocument, String>{

}
