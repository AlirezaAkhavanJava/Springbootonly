package com.me;

public class AccountOwnerNotExistsException extends RuntimeException {
    public AccountOwnerNotExistsException(String message) {
        super(message);
    }
}
