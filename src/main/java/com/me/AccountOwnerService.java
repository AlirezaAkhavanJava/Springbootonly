package com.me;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountOwnerService {
    private final AccountOwnerRepository accountOwnerRepository;

    @Transactional
    public AccountOwner createAccountOwner(AccountOwner accountOwner) {
        if (accountOwnerRepository.existsAccountOwnerByUsername(accountOwner.getUsername())) {
            throw new AccountOwnerAlreadyExists("Account owner already exists");
        } else return accountOwnerRepository.save(accountOwner);
    }


    @Transactional(readOnly = true)
    public AccountOwner findAccountOwnerByUsernameOrEmail(String identifier) {
        return accountOwnerRepository.findAccountOwnerByUsernameOrEmail(identifier)
                .orElseThrow(() -> new AccountOwnerNotExistsException("Account owner not exists"));
    }
}
