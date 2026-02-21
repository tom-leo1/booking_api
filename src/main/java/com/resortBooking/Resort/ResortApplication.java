package com.resortBooking.Resort;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ResortApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResortApplication.class, args);
	}

	@Bean
	public CommandLineRunner testMongoDBConnection(MongoTemplate mongoTemplate){
		return args -> {

			try{
				mongoTemplate.getDb().listCollectionNames().first();
				System.out.println("Connected to MongoDB");
			}
			catch (Exception e){
				System.out.println("Error in connecting to MongoDB"+e.getMessage());
			}
		};
	};





}
