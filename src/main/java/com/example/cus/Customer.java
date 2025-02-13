package com.example.cus;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name must not be null")
    @Size(min = 3, message = "First name must contain at least 3 characters")
    private String firstName;

    @NotNull(message = "Last name must not be null")
    @Size(min = 3, message = "Last name must contain at least 3 characters")
    private String lastName;

    @NotNull(message = "Email must not be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Password must not be null")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password must be alphanumeric")
    private String password;

    @NotNull(message = "Confirm password must not be null")
    @Size(min = 6, max = 20, message = "Confirm password must be between 6 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Confirm password must be alphanumeric")
    private String confirmPassword;

    @NotNull(message = "Mobile number must not be null")
    @ValidMobileNo
    private String mobileNo;

    @Min(value = 10000, message = "Salary must be at least 10,000")
    @Max(value = 50000, message = "Salary must not exceed 50,000")
    private Double salary;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    private Instant modifiedAt;

    @Version // Add this version field
    private Long version;  // Hibernate uses this field for optimistic locking

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getModifiedAt() { return modifiedAt; }
    public void setModifiedAt(Instant modifiedAt) { this.modifiedAt = modifiedAt; }

    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }
}
