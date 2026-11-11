package com.me.service.register;

import com.me.domain.mapper.AccountOwnerMapper;
import com.me.persistance.AccountOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final AccountOwnerRepository accountOwnerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountOwnerMapper accountOwnerMapper;

    @Override
    public String register(String username, String password, String email) {
        return "";
    }
}
