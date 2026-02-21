package com.arjuncode.turfbooking.service;

import com.arjuncode.turfbooking.dto.BookingRequestDTO;
import com.arjuncode.turfbooking.dto.BookingResponseDTO;


import java.util.List;

public interface BookingService {

        BookingResponseDTO createBooking(BookingRequestDTO request);

        BookingResponseDTO updateBooking(BookingResponseDTO updateRequest);
        BookingResponseDTO getBookingById(Long id);

        List<BookingResponseDTO> getAllBookings();

        void deleteBooking(Long id);
}
