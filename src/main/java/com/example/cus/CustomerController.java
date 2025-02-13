package com.example.cus;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create or Update Customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    // Get all Customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // Get Customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    // Delete Customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    // Find by First Name
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<Customer>> getCustomersByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(customerService.getCustomersByFirstName(firstName));
    }

    // Find by Last Name
    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<Customer>> getCustomersByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(customerService.getCustomersByLastName(lastName));
    }

    // Find by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(customerService.getCustomerByEmail(email));
    }

    // Find by Salary Range
    @GetMapping("/salary-range")
    public ResponseEntity<List<Customer>> getCustomersBySalaryRange(
            @RequestParam Double minSalary, @RequestParam Double maxSalary) {
        return ResponseEntity.ok(customerService.getCustomersBySalaryRange(minSalary, maxSalary));
    }

    // Find by Salary Greater Than
    @GetMapping("/salary-greater-than/{salary}")
    public ResponseEntity<List<Customer>> getCustomersBySalaryGreaterThan(@PathVariable Double salary) {
        return ResponseEntity.ok(customerService.getCustomersBySalaryGreaterThan(salary));
    }

    // Find by Name Starting With
    @GetMapping("/name-starts-with/{prefix}")
    public ResponseEntity<List<Customer>> getCustomersByFirstNameStartingWith(@PathVariable String prefix) {
        return ResponseEntity.ok(customerService.getCustomersByFirstNameStartingWith(prefix));
    }

    // Find by Email Domain
    @GetMapping("/email-domain/{domain}")
    public ResponseEntity<List<Customer>> getCustomersByEmailDomain(@PathVariable String domain) {
        return ResponseEntity.ok(customerService.getCustomersByEmailDomain(domain));
    }
}



