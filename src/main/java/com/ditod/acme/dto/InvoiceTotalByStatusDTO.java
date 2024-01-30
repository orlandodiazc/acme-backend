package com.ditod.acme.dto;


public interface InvoiceTotalByStatusDTO {
    Integer getTotalPaidInvoices();

    Integer getTotalPendingInvoices();
}