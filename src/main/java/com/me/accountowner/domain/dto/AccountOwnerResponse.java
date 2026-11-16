package com.me.accountowner.domain.dto;

import java.util.UUID;

public record AccountOwnerResponse(
        String username,
        UUID publicId
) {
}
