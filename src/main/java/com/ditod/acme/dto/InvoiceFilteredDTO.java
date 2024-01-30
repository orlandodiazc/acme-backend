package com.ditod.acme.dto;

import java.time.LocalDate;
import java.util.UUID;

public interface InvoiceFilteredDTO {
    UUID getId();

    Integer getAmount();

    LocalDate getProcessingDate();

    String getStatus();

    String getName();

    String getEmail();

    String getImageUrl();
}
