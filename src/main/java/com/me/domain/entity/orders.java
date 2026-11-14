package com.me.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "account_orders")
public class orders {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(
            name = "account_owner_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_order_account_owner")
    )
    private AccountOwner accountOwner;

    @Column(name = "order_name", nullable = false)
    private String orderName;

    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "payment_code", nullable = false, unique = true, updatable = false, length = 64)
    private String paymentCode;

    @Column(name = "purchased_at", nullable = false, updatable = false)
    private Instant purchasedAt = Instant.now();
}
