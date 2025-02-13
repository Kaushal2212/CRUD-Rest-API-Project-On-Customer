package com.example.cus;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface customerRepo extends JpaRepository<Customer, Long> {

    // Find customers by first name
    List<Customer> findByFirstName(String firstName);

    // Find customers by last name
    List<Customer> findByLastName(String lastName);

    // Find customers by email
    Customer findByEmail(String email);

    // Find customers by salary range
    List<Customer> findBySalaryBetween(Double minSalary, Double maxSalary);

    // Find customers with salary greater than a specific value
    List<Customer> findBySalaryGreaterThan(Double salary);

    // Find customers whose first name starts with a specific prefix
    List<Customer> findByFirstNameStartingWith(String prefix);

    // Find customers by email domain using a custom query
    @Query("SELECT c FROM Customer c WHERE c.email LIKE %:domain")
    List<Customer> findByEmailDomain(@Param("domain") String domain);
}

