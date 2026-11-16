package com.me.accountowner.exception;

public class AccountOwnerAlreadyExists extends RuntimeException {
    public AccountOwnerAlreadyExists(String message) {
        super(message);
    }
}
