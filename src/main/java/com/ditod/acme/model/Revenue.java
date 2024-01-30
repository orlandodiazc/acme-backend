package com.ditod.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Revenue {
    private @Id String monthName;
    private int revenue;

    public String getMonthName() {
        return monthName;
    }

    public int getRevenue() {
        return revenue;
    }
}
