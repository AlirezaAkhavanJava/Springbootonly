package com.me;

public class AccountOwnerAlreadyExists extends RuntimeException {
    public AccountOwnerAlreadyExists(String message) {
        super(message);
    }
}
