package com.arjuncode.turfbooking.service;

import com.arjuncode.turfbooking.dto.BookingRequestDTO;
import com.arjuncode.turfbooking.dto.BookingResponseDTO;
import com.arjuncode.turfbooking.entity.Booking;
import com.arjuncode.turfbooking.entity.Customer;
import com.arjuncode.turfbooking.entity.Turf;
import com.arjuncode.turfbooking.repo.BookingRepository;
import com.arjuncode.turfbooking.repo.CustomerRepository;
import com.arjuncode.turfbooking.repo.TurfRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final TurfRepository turfRepository;

    public BookingServiceImpl(
            BookingRepository bookingRepository,
            CustomerRepository customerRepository,
            TurfRepository turfRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.turfRepository = turfRepository;
    }

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Turf turf = turfRepository.findById(request.getTurfId())
                .orElseThrow(() -> new RuntimeException("Turf not found"));

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setTurf(turf);
        booking.setBookingDate(request.getBookingDate());
        booking.setStartTime(request.getStartTime());

        long minutes = request.getDurationInHours()
                    .multiply(BigDecimal.valueOf(60))
                    .longValueExact();

        booking.setEndTime(request.getStartTime().plusMinutes(minutes));
        booking.setDurationInHours(request.getDurationInHours());

        Booking saved = bookingRepository.save(booking);
        return mapToResponse(saved);
    }
    @Override
    public BookingResponseDTO updateBooking(BookingResponseDTO updateRequest) {

        Booking booking = bookingRepository.findById(updateRequest.getBookingId())
                .orElseThrow(()->new RuntimeException("Booking not found"));

        Customer customer = customerRepository.findById(updateRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Turf turf = turfRepository.findById(updateRequest.getTurfId())
                .orElseThrow(() -> new RuntimeException("Turf not found"));


        booking.setCustomer(customer);
        booking.setTurf(turf);
        booking.setBookingDate(updateRequest.getBookingDate());
        booking.setStartTime(updateRequest.getStartTime());

        long minutes = updateRequest.getDurationInHours()
                .multiply(BigDecimal.valueOf(60))
                .longValueExact();

        booking.setEndTime(updateRequest.getStartTime().plusMinutes(minutes));
        booking.setDurationInHours(updateRequest.getDurationInHours());

        Booking saved = bookingRepository.save(booking);
        return mapToResponse(saved);
    }


    @Override
    public BookingResponseDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return mapToResponse(booking);
    }

    @Override
    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    private BookingResponseDTO mapToResponse(Booking booking) {
        BookingResponseDTO dto = new BookingResponseDTO();
        dto.setBookingId(booking.getId());
        dto.setCustomerId(booking.getCustomer().getId());
        dto.setCustomerName(booking.getCustomer().getName());
        dto.setTurfId(booking.getTurf().getId());
        dto.setTurfName(booking.getTurf().getTurfName());
        dto.setBookingDate(booking.getBookingDate());
        dto.setStartTime(booking.getStartTime());
        dto.setEndTime(booking.getEndTime());
        dto.setDurationInHours(booking.getDurationInHours());
        return dto;
    }
}
