package com.moneymatters.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @Column(name = "sale_price")
    private Double price;

    @Column(name = "sale_status")
    private Boolean status;

    @Column(name = "sale_contract_type")
    private int contractType;

}
