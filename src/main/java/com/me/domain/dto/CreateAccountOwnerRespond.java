package com.me.domain.dto;

import java.util.UUID;

public record CreateAccountOwnerRespond(
        UUID publicId,
        String username
) {
}
