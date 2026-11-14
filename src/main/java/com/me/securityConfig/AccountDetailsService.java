package com.me.securityConfig;

import com.me.domain.entity.AccountOwner;
import com.me.persistance.AccountOwnerRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountDetailsService implements UserDetailsService {
    private final AccountOwnerRepository accountOwnerRepository;

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountOwner owner = accountOwnerRepository.findAccountOwnerByUsernameOrEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return User.withUsername(owner.getUsername())
                .password(owner.getPasswordHash())
                .disabled(!owner.isEnabled())
                .build();
    }
}
