package com.moneymatters.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "wallet_user_fk", nullable = false)
    private User user;

    @Column(name = "wallet_name", nullable = false)
    private String name;

}