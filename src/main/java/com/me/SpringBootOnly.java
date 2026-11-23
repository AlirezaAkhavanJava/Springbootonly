package com.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@EnableJpaAuditing
@EnableMethodSecurity
public class SpringBootOnly {

    static void main() throws NoSuchAlgorithmException {
       SpringApplication.run(SpringBootOnly.class);

    }
}
