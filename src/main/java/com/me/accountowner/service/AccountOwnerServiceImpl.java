package com.me.accountowner.service;


import com.me.accountowner.domain.dto.AccountOwnerResponse;
import com.me.accountowner.domain.entity.AccountOwner;
import com.me.accountowner.domain.mapper.AccountOwnerMapper;
import com.me.accountowner.domain.dto.CreateAccountOwnerRequest;
import com.me.accountowner.domain.dto.CreateAccountOwnerRespond;
import com.me.accountowner.exception.AccountOwnerAlreadyExists;
import com.me.accountowner.exception.AccountOwnerNotExistsException;
import com.me.accountowner.persistance.AccountOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountOwnerServiceImpl implements AccountOwnerService {
    private final AccountOwnerRepository accountOwnerRepository;
    private final AccountOwnerMapper mapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional(readOnly = true)
    public AccountOwner findAccountOwnerByUsernameOrEmail(String identifier) {
        return accountOwnerRepository.findAccountOwnerByUsernameOrEmail(identifier)
                .orElseThrow(() -> new AccountOwnerNotExistsException("Account owner not exists"));
    }

    @Transactional
    public CreateAccountOwnerRespond createAccount(CreateAccountOwnerRequest request) {

        String username = request.username().toLowerCase().trim();
        String email = request.email().toLowerCase().trim();

        if (accountOwnerRepository.existsAccountOwnerByUsername(username)) {
            throw new AccountOwnerAlreadyExists("Account already exists");
        }
        if (accountOwnerRepository.existsByEmail(email)) {
            throw new AccountOwnerAlreadyExists("Account already exists");
        }
        String hash = passwordEncoder.encode(request.passwordHash());
        AccountOwner accountOwner = AccountOwner.builder()
                .username(username)
                .email(email)
                .passwordHash(hash)
                .build();
        return mapper.fromAccountOwner(accountOwnerRepository.save(accountOwner));
    }

    @Override
    public AccountOwnerResponse findByUsername(String username) {
        AccountOwner owner = accountOwnerRepository.findByUsername(username)
                .orElseThrow(() -> new AccountOwnerNotExistsException("Account owner not exists"));
        return mapper.toAccountOwnerResponse(owner);
    }
}
