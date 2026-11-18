package com.me.accountowner.domain.dto;

import com.me.Configuration.RegexPatterns;
import com.me.Configuration.ValidationMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateAccountOwnerRequest(

        @NotBlank(message = ValidationMessages.USERNAME_BLANK)
        @Size(min = 6, max = 32, message = ValidationMessages.USERNAME_SIZE)
        @Pattern(
                regexp = RegexPatterns.USERNAME,
                message = ValidationMessages.USERNAME_PATTERN
        )
        String username,

        @NotBlank(message = ValidationMessages.PASSWORD_BLANK)
        @Size(min = 8, max = 72, message = ValidationMessages.PASSWORD_SIZE)
        @Pattern(
                regexp = RegexPatterns.STRONG_PASSWORD,
                message = ValidationMessages.PASSWORD_PATTERN
        )
        String passwordHash,

        @NotBlank(message = ValidationMessages.EMAIL_BLANK)
        @Email(message = ValidationMessages.EMAIL_PATTERN)
        @Size(min = 6, max = 254, message = ValidationMessages.EMAIL_SIZE)
        @Pattern(regexp = RegexPatterns.EMAIL, message = ValidationMessages.EMAIL_PATTERN)
        String email

) {

}
