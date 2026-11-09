package com.me.lifecycle;

import com.me.Conflict.AccountOwner;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SmartProcess implements AProcess {
    private  AccountOwner accountOwner;
}
