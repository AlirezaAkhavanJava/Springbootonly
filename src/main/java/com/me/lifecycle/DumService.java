package com.me.lifecycle;

import com.me.AccountOwner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Setter
@AllArgsConstructor
@Getter
public class DumService implements AProcess {
    private final String author;
    private final AccountOwner owner;
}
