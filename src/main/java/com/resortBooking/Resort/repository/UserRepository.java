package com.resortBooking.Resort.repository;

import com.resortBooking.Resort.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByUsername(String username);
}

