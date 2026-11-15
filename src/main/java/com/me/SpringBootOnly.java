package com.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootOnly {

    static void main() throws NoSuchAlgorithmException {
       SpringApplication.run(SpringBootOnly.class);

    }
}
