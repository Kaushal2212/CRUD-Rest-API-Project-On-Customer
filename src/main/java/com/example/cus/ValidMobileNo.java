package com.example.cus;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MobileNoValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMobileNo {
    String message() default "Mobile number must be exactly 10 digits long and contain only digits";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}

