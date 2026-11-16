package com.me.accountowner.domain.mapper;

import com.me.accountowner.domain.dto.AccountOwnerResponse;
import com.me.accountowner.domain.entity.AccountOwner;
import com.me.accountowner.domain.dto.CreateAccountOwnerRequest;
import com.me.accountowner.domain.dto.CreateAccountOwnerRespond;
import org.springframework.stereotype.Component;

@Component
public class AccountOwnerMapper {

    public CreateAccountOwnerRespond fromAccountOwner(AccountOwner accountOwner) {
        return new CreateAccountOwnerRespond(accountOwner.getPublicId(), accountOwner.getUsername());
    }

    public AccountOwner toAccountOwner(CreateAccountOwnerRequest createAccountOwnerRequest) {
        return AccountOwner.builder()
                .username(createAccountOwnerRequest.username())
                .passwordHash(createAccountOwnerRequest.passwordHash())
                .email(createAccountOwnerRequest.email())
                .build();
    }

    public AccountOwnerResponse toAccountOwnerResponse(AccountOwner accountOwner) {
        return new AccountOwnerResponse(accountOwner.getUsername(), accountOwner.getPublicId());
    }
}
