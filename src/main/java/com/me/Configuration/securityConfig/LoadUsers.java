package com.me.Configuration.securityConfig;

import com.me.accountowner.domain.entity.AccountOwner;
import com.me.accountowner.persistance.AccountOwnerRepository;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadUsers implements UserDetailsService {

    private final AccountOwnerRepository repo;

    @Override
    @Nonnull
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountOwner owner = repo
                .findByUsername(username.toLowerCase().trim())
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return AccountOwnerDetails.builder()
                .username(owner.getUsername())
                .passwordHash(owner.getPasswordHash())
                .enabled(owner.isEnabled())
                .locked(owner.isLocked())
                .role(owner.getRole())
                .build();
    }
}
