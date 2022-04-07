package com.api.identitydocument.repository.intf;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.api.identitydocument.entity.Setup;

public interface ISetupRepository extends MongoRepository<Setup, String>{
	
	@Query("{keyName: '?0'}")
	Setup findItemByKeyName(String keyValue);

}
