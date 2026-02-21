package com.resortBooking.Resort.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "bookings")
@JsonIgnoreProperties({"user"})
public record Booking(
        @Id String bookingId,
        String bookingName,
        int noOfGuests,
        LocalDate checkInDate,
        LocalDate checkOutDate,
        @DBRef UserModel user) {

}
