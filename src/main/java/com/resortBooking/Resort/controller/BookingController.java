package com.resortBooking.Resort.controller;

import com.resortBooking.Resort.models.Booking;
import com.resortBooking.Resort.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("")
    public List<Booking> getBookings(){
        return bookingService.fetchMyBookings();
    }
    @PostMapping("")
    public String createBooking(@RequestBody Booking booking){
        return bookingService.createUserBooking(booking);
    }
}
