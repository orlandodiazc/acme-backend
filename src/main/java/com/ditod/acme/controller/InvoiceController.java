package com.ditod.acme.controller;

import com.ditod.acme.dto.InvoiceDetailsDTO;
import com.ditod.acme.dto.InvoiceFilteredPageableDTO;
import com.ditod.acme.exception.InvoiceNotFoundException;
import com.ditod.acme.model.Invoice;
import com.ditod.acme.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    InvoiceFilteredPageableDTO filteredInvoices(@RequestParam(required = false,
            defaultValue = "") String query, @RequestParam(required = false,
            defaultValue = "1") Integer page) {
        return invoiceService.findFilteredInvoices(query, page);
    }

    @GetMapping("/invoices/latest")
    List<InvoiceDetailsDTO> latestInvoices() {
        return invoiceService.findLatestInvoices();
    }

    @GetMapping("/invoices/{id}")
    Invoice one(@PathVariable UUID id) {
        return invoiceService.findInvoiceById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
    }

}
