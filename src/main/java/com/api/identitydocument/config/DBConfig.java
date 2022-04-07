package com.api.identitydocument.config;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mongodb.client.MongoClient;

@Configuration
public class DBConfig {
	
	private static final Logger logger = LogManager.getLogger(DBConfig.class);
	
	@Autowired
	private Environment env;
	
	@SuppressWarnings("unused")
	private String getDatabaseName() {
        return env.getProperty("spring.data.mongodb.database");
    }
	
	public MongoClient mongoClient() {
		/*logger.info("Start conecction");
        ConnectionString connectionString = new ConnectionString(env.getProperty("spring.data.mongodb.uri"));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        logger.info("Connection finished");
        
        return MongoClients.create(mongoClientSettings);*/
		return null;
    }
 
    @SuppressWarnings("rawtypes")
	public Collection getMappingBasePackages() {
        return null;//return Collections.singleton("com.api.identitydocument.entity");
    }

}
