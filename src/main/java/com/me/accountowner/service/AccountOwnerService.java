package com.me.accountowner.service;

import com.me.accountowner.domain.dto.AccountOwnerResponse;
import com.me.accountowner.domain.entity.AccountOwner;
import com.me.accountowner.domain.dto.CreateAccountOwnerRequest;
import com.me.accountowner.domain.dto.CreateAccountOwnerRespond;

public interface AccountOwnerService {

    AccountOwner findAccountOwnerByUsernameOrEmail(String identifier);
    CreateAccountOwnerRespond createAccount(CreateAccountOwnerRequest request);

    AccountOwnerResponse findByUsername(String username);
}
