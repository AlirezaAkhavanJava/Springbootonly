package com.me.accountowner.representation;

import com.me.Configuration.RegexPatterns;
import com.me.Configuration.ValidationMessages;
import com.me.accountowner.domain.dto.AccountOwnerResponse;
import com.me.accountowner.domain.dto.CreateAccountOwnerRequest;
import com.me.accountowner.domain.dto.CreateAccountOwnerRespond;
import com.me.accountowner.domain.mapper.AccountOwnerMapper;
import com.me.accountowner.service.AccountOwnerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class AccountOwnerController {

    private final AccountOwnerService accountOwnerService;
    private final AccountOwnerMapper accountOwnerMapper;


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAccountOwnerRespond createAccount(
            @Valid
            @RequestBody
            CreateAccountOwnerRequest request) {
        return accountOwnerService.createAccount(request);

    }

    @GetMapping("{identifier}")
    public CreateAccountOwnerRespond get(
            @PathVariable
            @NotBlank
            @Pattern(
                    regexp = RegexPatterns.IDENTIFIER_EMAIL_USERNAME,
                    message = ValidationMessages.EMAIL_PATTERN
            )
            String identifier) {
        return accountOwnerMapper.fromAccountOwner(accountOwnerService.findAccountOwnerByUsernameOrEmail(identifier.toLowerCase()));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<AccountOwnerResponse> findByUserName(
            @PathVariable
            @NotBlank(message = ValidationMessages.EMAIL_BLANK)
            @Pattern(
                    regexp = RegexPatterns.USERNAME,
                    message = ValidationMessages.USERNAME_PATTERN
            )
            String username
    ) {
        AccountOwnerResponse owner = accountOwnerService.findByUsername(username.toLowerCase());
        return ResponseEntity.ok(owner);
    }
}
