package com.me.dummy;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ConfigRun {

    private final PasswordEncoder passwordEncoder;

    public ConfigRun(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void hasher() {
        String password = passwordEncoder.encode("password12355");
        String passwordSalt = passwordEncoder.encode("password12355");
        System.out.println(password);
        System.out.println(passwordSalt);
    }
}
