package com.me.domain.mapper;

import com.me.domain.AccountOwner;
import com.me.domain.CreateAccountOwnerRequest;
import com.me.domain.CreateAccountOwnerRespond;
import org.springframework.stereotype.Component;

@Component
public class AccountOwnerMapper {

    public CreateAccountOwnerRespond fromAccountOwner(AccountOwner accountOwner) {
        return new CreateAccountOwnerRespond(accountOwner.getId(), accountOwner.getUsername());
    }

    public AccountOwner toAccountOwner(CreateAccountOwnerRequest createAccountOwnerRequest) {
        return AccountOwner.builder()
                .username(createAccountOwnerRequest.username())
                .passwordHash(createAccountOwnerRequest.passwordHash())
                .email(createAccountOwnerRequest.email())
                .build();
    }
}
