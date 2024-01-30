package com.ditod.acme.dto;


public interface InvoiceTotalByStatusDTO {
    Integer getPaidInvoicesTotal();

    Integer getPendingInvoicesTotal();
}