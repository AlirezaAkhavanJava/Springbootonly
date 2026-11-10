package com.me.service;

import com.me.domain.AccountOwner;
import com.me.domain.CreateAccountOwnerRequest;
import com.me.domain.CreateAccountOwnerRespond;

public interface AccountOwnerService {

    AccountOwner findAccountOwnerByUsernameOrEmail(String identifier);

    CreateAccountOwnerRespond createAccount(CreateAccountOwnerRequest request);
}
