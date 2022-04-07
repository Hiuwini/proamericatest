package com.api.identitydocument.repository.intf;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.api.identitydocument.entity.JWT;

public interface IJWTRepository extends MongoRepository<JWT, String>{
	
	@Query("{'client.client': '?0', 'client.key': '?1'}")
	JWT findByClientAndKey(String client, String key);
	
	@Query("{refreshToken: '?0', 'client.client': '?1', 'client.key': '?2'}")
	JWT findByRefreshTokenAndClient(String refreshToken, String client, String key);

}
