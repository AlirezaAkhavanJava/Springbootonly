package com.me.Configuration.securityConfig;

import com.me.accountowner.domain.AccountOwnerRole;
import jakarta.annotation.Nonnull;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
public class AccountOwnerDetails implements UserDetails {

    private final String username;
    private final String passwordHash;
    private final boolean enabled;
    private final boolean locked;
    private final AccountOwnerRole role;

    public AccountOwnerDetails(String username, String passwordHash, boolean enabled, boolean locked, AccountOwnerRole role) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.enabled = enabled;
        this.locked = locked;
        this.role = role;
    }

    @Override
    @Nonnull
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    @Nonnull
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

