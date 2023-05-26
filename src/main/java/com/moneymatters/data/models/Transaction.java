package com.moneymatters.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id", nullable = false)
    private TransactionType transactionType;

    @Column(name = "transaction_amount", nullable = false)
    private BigDecimal amount;


    @Column(name = "transaction_created_at", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "transaction_updated_at")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}