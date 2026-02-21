package com.arjuncode.turfbooking.controller;


import com.arjuncode.turfbooking.dto.BookingRequestDTO;
import com.arjuncode.turfbooking.dto.BookingResponseDTO;
import com.arjuncode.turfbooking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // CREATE
    @PostMapping
    public BookingResponseDTO createBooking(@RequestBody BookingRequestDTO request) {
        return bookingService.createBooking(request);
    }

    // READ (by id)
    @GetMapping("/{id}")
    public BookingResponseDTO getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    // READ (all)
    @GetMapping
    public List<BookingResponseDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}
