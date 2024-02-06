package com.ditod.acme.service;

import com.ditod.acme.dto.InvoiceDetailsDTO;
import com.ditod.acme.dto.InvoiceTotalByStatusDTO;
import com.ditod.acme.dto.OverviewDTO;
import com.ditod.acme.entity.Revenue;
import com.ditod.acme.repository.CustomerRepository;
import com.ditod.acme.repository.RevenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverviewService {
    private final InvoiceService invoiceService;
    private final CustomerRepository customerRepository;
    private final RevenueRepository revenueRepository;

    public OverviewService(InvoiceService invoiceService,
                           CustomerRepository customerRepository,
                           RevenueRepository revenueRepository) {
        this.invoiceService = invoiceService;
        this.customerRepository = customerRepository;
        this.revenueRepository = revenueRepository;
    }

    public OverviewDTO findOverview() {
        Long invoiceCount = invoiceService.countInvoices();
        Long customerCount = customerRepository.count();
        InvoiceTotalByStatusDTO invoiceTotalByStatus =
                invoiceService.findInvoiceTotalByStatus();
        List<InvoiceDetailsDTO> latestInvoices = invoiceService.findLatestInvoices();
        List<Revenue> revenues = revenueRepository.findAll();

        return new OverviewDTO(invoiceCount, customerCount,
                invoiceTotalByStatus.getPaidInvoicesTotal(),
                invoiceTotalByStatus.getPendingInvoicesTotal(), revenues, latestInvoices);
    }
}
