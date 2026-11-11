package com.me.representation;

import com.me.domain.dto.CreateAccountOwnerRequest;
import com.me.domain.dto.CreateAccountOwnerRespond;
import com.me.domain.mapper.AccountOwnerMapper;
import com.me.service.AccountOwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class AccountOwnerController {

    private final AccountOwnerService accountOwnerService;
    private final AccountOwnerMapper accountOwnerMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    public CreateAccountOwnerRespond createAccount(@Valid @RequestBody CreateAccountOwnerRequest request) {
        return accountOwnerService.createAccount(request);

    }

    @GetMapping("{identifier}")
    public CreateAccountOwnerRespond get(@PathVariable(name = "identifier") String identifier) {
        return accountOwnerMapper.fromAccountOwner(accountOwnerService.findAccountOwnerByUsernameOrEmail(identifier));
    }
}
