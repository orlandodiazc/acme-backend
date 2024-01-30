package com.ditod.acme.dto;

public record OverviewStatsDTO(
        Long invoiceCount,
        Long customerCount,
        Integer totalPaidInvoices,
        Integer totalPendingInvoices) {
}