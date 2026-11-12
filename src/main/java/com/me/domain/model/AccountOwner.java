package com.me.domain.model;

import com.me.domain.AccountOwnerRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

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

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
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
    private AccountOwnerRole role = AccountOwnerRole.USER;


    @Builder
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
