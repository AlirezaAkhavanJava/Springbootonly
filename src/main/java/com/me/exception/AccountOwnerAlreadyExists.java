package com.me.exception;

public class AccountOwnerAlreadyExists extends RuntimeException {
    public AccountOwnerAlreadyExists(String message) {
        super(message);
    }
}
