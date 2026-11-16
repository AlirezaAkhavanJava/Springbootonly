package com.me.accountowner.exception;

public class AccountOwnerNotExistsException extends RuntimeException {
    public AccountOwnerNotExistsException(String message) {
        super(message);
    }
}
