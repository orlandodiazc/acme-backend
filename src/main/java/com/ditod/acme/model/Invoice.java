package com.ditod.acme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private LocalDate processingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @Column(name = "customer_id", updatable = false, insertable = false)
    private UUID customerId;

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

    public UUID getCustomerId() {
        return customerId;
    }
}
