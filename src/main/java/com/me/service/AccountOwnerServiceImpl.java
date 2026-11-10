package com.me.service;


import com.me.domain.AccountOwner;
import com.me.domain.mapper.AccountOwnerMapper;
import com.me.domain.CreateAccountOwnerRequest;
import com.me.domain.CreateAccountOwnerRespond;
import com.me.exception.AccountOwnerAlreadyExists;
import com.me.exception.AccountOwnerNotExistsException;
import com.me.persistance.AccountOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountOwnerServiceImpl implements AccountOwnerService {
    private final AccountOwnerRepository accountOwnerRepository;
    private final AccountOwnerMapper mapper;


    @Override
    @Transactional(readOnly = true)
    public AccountOwner findAccountOwnerByUsernameOrEmail(String identifier) {
        return accountOwnerRepository.findAccountOwnerByUsernameOrEmail(identifier)
                .orElseThrow(() -> new AccountOwnerNotExistsException("Account owner not exists"));
    }

    @Transactional
    public CreateAccountOwnerRespond createAccount(CreateAccountOwnerRequest request) {
        if (accountOwnerRepository.existsAccountOwnerByUsername(request.username())) {
            throw new AccountOwnerAlreadyExists("Account owner already exists");
        } else {
            AccountOwner accountOwner = accountOwnerRepository.save(mapper.toAccountOwner(request));
            return mapper.fromAccountOwner(accountOwner);
        }
    }
}
