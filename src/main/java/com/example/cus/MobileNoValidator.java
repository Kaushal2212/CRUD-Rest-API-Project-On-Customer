package com.example.cus;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileNoValidator implements ConstraintValidator<ValidMobileNo, String> {

    @Override
    public boolean isValid(String mobileNo, ConstraintValidatorContext context) {
        if (mobileNo == null || mobileNo.isEmpty()) {
            return false; // Mobile number must not be null or empty
        }
        return mobileNo.matches("\\d{10}"); // Ensures exactly 10 digits
    }
}


