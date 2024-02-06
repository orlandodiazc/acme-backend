package com.ditod.acme.dto;

import com.ditod.acme.model.Status;

import java.util.UUID;

public record RequestInvoiceDTO(UUID customerId, int amount, Status status) {
}
