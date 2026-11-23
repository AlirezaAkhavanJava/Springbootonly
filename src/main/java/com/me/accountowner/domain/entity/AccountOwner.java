package com.me.accountowner.domain.entity;

import com.me.accountowner.domain.AccountOwnerRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account_user")
public class AccountOwner {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accountOwner_gen"
    )
    @SequenceGenerator(
            name = "accountOwner_gen",
            sequenceName = "account_owner_seq",
            initialValue = 100,
            allocationSize = 1
    )
    @Column(nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private Long id;

    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "public_id", nullable = false, updatable = false)
    private UUID publicId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    @Getter
    private String passwordHash;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private boolean enabled = true;

    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private boolean locked = false;

    @Column(nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private Instant createdAt = Instant.now();

    @Enumerated(EnumType.STRING)
    @Setter(AccessLevel.NONE)
    @Column(name = "user_role", nullable = false)
    private AccountOwnerRole role = AccountOwnerRole.ROLE_USER;


    @Builder
    @SuppressWarnings("unused")
    public AccountOwner(
            String username,
            String passwordHash,
            String email
    ) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
    }

}
