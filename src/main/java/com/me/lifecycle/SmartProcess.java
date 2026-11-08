package com.me.lifecycle;

import com.me.AccountOwner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Setter
@Getter
@Component
public class SmartProcess implements AProcess {
    private final AccountOwner accountOwner;
}
