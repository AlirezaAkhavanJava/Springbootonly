package com.me.lifecycle;

import com.me.AccountOwner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DumService implements AProcess  {
    private  String author;
    private  AccountOwner owner;

}
