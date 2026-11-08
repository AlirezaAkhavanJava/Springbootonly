package com.me.arr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class Config<AccountOwner> {
    @Bean
    public ArrayList<AccountOwner> arrayList() {
        return new ArrayList<AccountOwner>();
    }
}
