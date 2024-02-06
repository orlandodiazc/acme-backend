package com.ditod.acme.dto;

import com.ditod.acme.entity.Revenue;

import java.util.List;

public record OverviewDTO(
        Long invoiceCount,
        Long customerCount,
        Integer totalPaidInvoices,
        Integer totalPendingInvoices,
        List<Revenue> revenues,
        List<InvoiceDetailsDTO> latestInvoices) {
}