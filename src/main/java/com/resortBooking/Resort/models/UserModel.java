package com.resortBooking.Resort.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "users")
@JsonIgnoreProperties({"bookings"})
public record UserModel(
        @Id String userId,
        String username,
         String password,
        @DBRef List<Booking> bookings) {
}
