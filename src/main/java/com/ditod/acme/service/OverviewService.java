package com.ditod.acme.service;

import com.ditod.acme.dto.InvoiceTotalByStatusDTO;
import com.ditod.acme.dto.OverviewStatsDTO;
import com.ditod.acme.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class OverviewService {
    private final InvoiceService invoiceService;
    private final CustomerRepository customerRepository;

    public OverviewService(InvoiceService invoiceService,
                           CustomerRepository customerRepository) {
        this.invoiceService = invoiceService;
        this.customerRepository = customerRepository;
    }

    public OverviewStatsDTO findOverviewStats() {
        InvoiceTotalByStatusDTO invoiceTotalByStatus =
                invoiceService.findInvoiceTotalByStatus();
        Long invoiceCount = invoiceService.count();
        Long customerCount = customerRepository.count();
        return new OverviewStatsDTO(invoiceCount, customerCount,
                invoiceTotalByStatus.getPaidInvoicesTotal(),
                invoiceTotalByStatus.getPendingInvoicesTotal());
    }
}
