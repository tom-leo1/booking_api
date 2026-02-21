package com.resortBooking.Resort.repository;

import com.resortBooking.Resort.models.Booking;
import com.resortBooking.Resort.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByUser(UserModel user);
}
