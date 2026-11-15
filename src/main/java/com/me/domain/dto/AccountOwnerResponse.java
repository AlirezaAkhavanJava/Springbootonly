package com.me.domain.dto;

import java.util.UUID;

public record AccountOwnerResponse(
        String username,
        UUID publicId
) {
}
