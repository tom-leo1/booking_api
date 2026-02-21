package com.resortBooking.Resort.service;

import com.resortBooking.Resort.models.Booking;
import com.resortBooking.Resort.models.UserModel;
import com.resortBooking.Resort.repository.BookingRepository;
import com.resortBooking.Resort.repository.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Booking> fetchMyBookings(){
        String currentUser = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        UserModel user = userRepository.findByUsername(currentUser);
        return bookingRepository.findByUser(user);
    }

    public String createUserBooking(Booking booking){
        String currentUser = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        UserModel user = userRepository.findByUsername(currentUser);
        Booking newBookingWithUser = new Booking(
                booking.bookingId(),
                booking.bookingName(),
                booking.noOfGuests(),
                booking.checkInDate(),
                booking.checkOutDate(),
                user
        );
         bookingRepository.save(newBookingWithUser);
         return "Hotel Booked!!.Thank you!!";

    }


}
