package com.me.service;

import com.me.domain.model.AccountOwner;
import com.me.domain.dto.CreateAccountOwnerRequest;
import com.me.domain.dto.CreateAccountOwnerRespond;

public interface AccountOwnerService {

    AccountOwner findAccountOwnerByUsernameOrEmail(String identifier);

    CreateAccountOwnerRespond createAccount(CreateAccountOwnerRequest request);
}
