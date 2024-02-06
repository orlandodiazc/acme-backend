package com.ditod.acme.dto;

import com.ditod.acme.model.Status;

import java.time.LocalDate;
import java.util.UUID;

public interface InvoiceFilteredDTO {
    UUID getId();

    Integer getAmount();

    LocalDate getProcessingDate();

    Status getStatus();

    String getName();

    String getEmail();

    String getImageUrl();
}
