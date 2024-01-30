package com.ditod.acme.dto;

import java.util.UUID;

public interface InvoiceDetailsDTO {
    UUID getId();

    Integer getAmount();

    String getName();

    String getImageUrl();

    String getEmail();
}
