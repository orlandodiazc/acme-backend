package com.ditod.acme.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {
    private @Id
    @GeneratedValue(strategy = GenerationType.UUID) UUID id;
    private String name;
    private String email;

    private String imageUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Invoice> invoices;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
