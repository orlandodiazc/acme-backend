package com.ditod.acme.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "invoices")
public class Invoice {
    private @Id
    @GeneratedValue(strategy = GenerationType.UUID) UUID id;

    private int amount;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public UUID getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getProcessingDate() {
        return processingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    private LocalDate processingDate;


}
