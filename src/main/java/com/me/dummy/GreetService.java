package com.me.dummy;

import com.me.AccountOwner;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class GreetService {
    private final GreetRepository greetRepository;
    private final ArrayList<AccountOwner> owners;
    @Value("${greet.message}")
    private final String someThing;
}
