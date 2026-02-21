package com.arjuncode.turfbooking.service;

import com.arjuncode.turfbooking.dto.CustomerRequestDTO;
import com.arjuncode.turfbooking.dto.CustomerResponseDTO;


import java.util.List;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CustomerRequestDTO request);

    CustomerResponseDTO getCustomerById(Long id);

    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO request);
//
    void deleteCustomer(Long id);
}
