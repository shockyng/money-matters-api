package com.moneymatters.data.models;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public boolean isValid() {
        if (price == null || price < 0) {
            return false;
        }
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (description == null || description.trim().isEmpty()) {
            return false;
        }
        if (paymentType == null || paymentType.trim().isEmpty()) {
            return false;
        }
        if (installments == null || installments < 0) {
            return false;
        }
        if (dueDate == null) {
            return false;
        }
        return true;
    }

}
