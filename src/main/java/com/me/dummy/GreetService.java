package com.me.dummy;

import com.me.AccountOwner;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GreetService {

    private final GreetRepository greetRepository;
    private final ArrayList<AccountOwner> owners;
    private final String someThing;

    public GreetService(
            GreetRepository greetRepository,
            ArrayList<AccountOwner> owners,
            @Value("${greet.message}") String someThing
    ) {
        this.greetRepository = greetRepository;
        this.owners = owners;
        this.someThing = someThing;
    }
}
