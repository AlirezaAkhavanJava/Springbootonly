package com.me;

import com.me.Conflict.AccountOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WhatAConstructor {

    private final String name;
    private final AccountOwner accountOwner;
    private final Integer mark;
    private final IAmGonnaBeInjected injected;


    @Autowired
    public WhatAConstructor(IAmGonnaBeInjected injected) {
        this.name = "Default";
        this.accountOwner = null;
        this.mark = 0;
        this.injected = injected;
    }

    public WhatAConstructor(
            String name,
            AccountOwner accountOwner,
            Integer mark
    ) {
        this.name = name;
        this.accountOwner = accountOwner;
        this.mark = mark;
        this.injected = null;
    }
}
