package com.me.service;

import com.me.domain.dto.AccountOwnerResponse;
import com.me.domain.entity.AccountOwner;
import com.me.domain.dto.CreateAccountOwnerRequest;
import com.me.domain.dto.CreateAccountOwnerRespond;
import org.springframework.http.ResponseEntity;

public interface AccountOwnerService {

    AccountOwner findAccountOwnerByUsernameOrEmail(String identifier);
    CreateAccountOwnerRespond createAccount(CreateAccountOwnerRequest request);

    AccountOwnerResponse findByUsername(String username);
}
