package com.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SpringBootOnly {

    static void main() throws NoSuchAlgorithmException {
       SpringApplication.run(SpringBootOnly.class);

    }
}
