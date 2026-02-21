package com.arjuncode.turfbooking.controller;

import com.arjuncode.turfbooking.dto.CustomerRequestDTO;
import com.arjuncode.turfbooking.dto.CustomerResponseDTO;
import com.arjuncode.turfbooking.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

//    @Autowired
//    private CustomerService customerService; ( THIS IS OLD APPROACH - FIELD INJECTION)
    //(Constructor injection - new approach)
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponseDTO createCustomer(@RequestBody CustomerRequestDTO request) {
        return customerService.createCustomer(request);
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable Long id, CustomerRequestDTO request){
        return customerService.updateCustomer(id,request);
    }
    // GET ALL
    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
