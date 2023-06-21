package com.moneymatters.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @Column(name = "bill_price")
    private Double price;

    @Column(name = "bill_name")
    private String name;

    @Column(name = "bill_description")
    private String description;

    @Column(name = "bill_payment_type")
    private String paymentType;

    @Column(name = "bill_installments")
    private Integer installments;

    @Column(name = "bill_due_date")
    private Date dueDate;
    
    @JoinColumn(name = "user_fk")
    @ManyToOne
    private User user;

}