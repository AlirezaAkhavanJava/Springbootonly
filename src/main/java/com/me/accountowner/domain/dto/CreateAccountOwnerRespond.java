package com.me.accountowner.domain.dto;

import java.util.UUID;

public record CreateAccountOwnerRespond(
        UUID publicId,
        String username
) {
}
