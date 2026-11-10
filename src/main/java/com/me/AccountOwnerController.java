package com.me;

import jakarta.servlet.ServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class AccountOwnerController {

    private final AccountOwnerService accountOwnerService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAccountOwnerRespond createAccountOwner(
            @Valid @RequestBody CreateAccountOwnerRequest createAccountOwnerRequest) {
        return CreateAccountOwnerRespond.from(accountOwnerService.createAccountOwner(
                AccountOwner.builder()
                        .username(createAccountOwnerRequest.username())
                        .passwordHash(createAccountOwnerRequest.passwordHash())
                        .build()
        ));
    }

    @GetMapping("{identifier}")
    public CreateAccountOwnerRespond get(@PathVariable String identifier) {
        return CreateAccountOwnerRespond.from(accountOwnerService.findAccountOwnerByUsernameOrEmail(identifier));
    }
}
