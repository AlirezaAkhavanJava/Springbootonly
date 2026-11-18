package com.me.accountowner.domain.dto;

import com.me.Configuration.RegexPatterns;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateAccountOwnerRequest(

        @NotBlank(message = "Username cannot be blank")
        @Size(min = 6, max = 32, message = "Username must be between 6 and 32 characters")
        @Pattern(
                regexp = RegexPatterns.USERNAME,
                message = "Username can only contain letters, numbers, and underscores"
        )
        String username,

        @NotBlank(message = "Password cannot be blank")
        @Size(min = 8, max = 72, message = "Password must be between 8 and 72 characters")
        @Pattern(
                regexp = RegexPatterns.STRONG_PASSWORD,
                message = "Password must contain uppercase, lowercase, number, and special character"
        )
        String passwordHash,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email address")
        @Size(min = 6, max = 254, message = "Email cannot exceed 254 characters")
        @Pattern(regexp = RegexPatterns.EMAIL, message = "Email is invalid")
        String email

) {

}
