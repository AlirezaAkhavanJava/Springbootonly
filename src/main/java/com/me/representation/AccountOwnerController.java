package com.me.representation;

import com.me.domain.dto.AccountOwnerResponse;
import com.me.domain.dto.CreateAccountOwnerRequest;
import com.me.domain.dto.CreateAccountOwnerRespond;
import com.me.domain.mapper.AccountOwnerMapper;
import com.me.service.AccountOwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
public class AccountOwnerController {

    private final AccountOwnerService accountOwnerService;
    private final AccountOwnerMapper accountOwnerMapper;


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAccountOwnerRespond createAccount(@Valid @RequestBody CreateAccountOwnerRequest request) {
        return accountOwnerService.createAccount(request);

    }

    @GetMapping("{identifier}")
    public CreateAccountOwnerRespond get(@PathVariable String identifier) {
        return accountOwnerMapper.fromAccountOwner(accountOwnerService.findAccountOwnerByUsernameOrEmail(identifier));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<AccountOwnerResponse> findByUserName(@PathVariable String username) {
        AccountOwnerResponse owner = accountOwnerService.findByUsername(username);
        return ResponseEntity.ok(owner);
    }
}
