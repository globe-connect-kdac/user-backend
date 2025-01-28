package com.blogs.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddUserDto {

    // Strict validation for email
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format. Must be a valid email address.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email must follow a strict format (e.g., example@domain.com).")
    private String email;

    // Strict validation for password
    @NotEmpty(message = "Password cannot be empty")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=])[A-Za-z\\d@#$%^&+=]$", message = "Password must be 8-20 characters long, contain at least one letter, one number, and one special character (@#$%^&+=).")
    private String password;

    // First Name validation
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    // Last Name validation
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;
}
