package com.me;

public record CreateAccountOwnerRespond(
        Long id,
        String username
) {
    static CreateAccountOwnerRespond from(AccountOwner accountOwner) {
        return new CreateAccountOwnerRespond(accountOwner.getId(), accountOwner.getUsername());
    }
}
