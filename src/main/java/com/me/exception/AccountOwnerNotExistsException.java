package com.me.exception;

public class AccountOwnerNotExistsException extends RuntimeException {
    public AccountOwnerNotExistsException(String message) {
        super(message);
    }
}
