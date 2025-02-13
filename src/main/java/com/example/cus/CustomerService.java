package com.example.cus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private customerRepo customerRepository;

    // Create or Update Customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Delete customer by ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Find by First Name
    public List<Customer> getCustomersByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    // Find by Last Name
    public List<Customer> getCustomersByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    // Find by Email
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    // Find by Salary Range
    public List<Customer> getCustomersBySalaryRange(Double minSalary, Double maxSalary) {
        return customerRepository.findBySalaryBetween(minSalary, maxSalary);
    }

    // Find by Salary Greater Than
    public List<Customer> getCustomersBySalaryGreaterThan(Double salary) {
        return customerRepository.findBySalaryGreaterThan(salary);
    }

    // Find by Name Starting With
    public List<Customer> getCustomersByFirstNameStartingWith(String prefix) {
        return customerRepository.findByFirstNameStartingWith(prefix);
    }

    // Find by Email Domain
    public List<Customer> getCustomersByEmailDomain(String domain) {
        return customerRepository.findByEmailDomain(domain);
    }
}

