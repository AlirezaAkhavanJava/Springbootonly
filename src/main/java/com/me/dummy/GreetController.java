package com.me.dummy;

import com.me.AccountOwner;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/greet")
public class GreetController {

    private final GreetService greetService;

    @GetMapping
    public String greet() {
        return "Hello account user ";
    }

    @GetMapping(path = "/dummy")
    public AccountOwner returnADummyUser() {
        return AccountOwner.builder()
                .username("Alireza")
                .password("12345678")
                .build();
    }
}
