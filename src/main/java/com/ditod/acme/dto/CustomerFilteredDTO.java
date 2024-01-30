package com.ditod.acme.dto;

import java.util.UUID;

public interface CustomerFilteredDTO {
    UUID getId();

    String getName();

    String getEmail();

    String getImageUrl();

    Integer getInvoicesCount();

    Integer getPaidInvoicesTotal();

    Integer getPendingInvoicesTotal();
}
