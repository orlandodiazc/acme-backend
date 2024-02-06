package com.ditod.acme.controller;

import com.ditod.acme.dto.InvoiceDetailsDTO;
import com.ditod.acme.dto.InvoiceFilteredPageableDTO;
import com.ditod.acme.dto.RequestInvoiceDTO;
import com.ditod.acme.entity.Invoice;
import com.ditod.acme.exception.InvoiceNotFoundException;
import com.ditod.acme.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/invoices")
    Invoice newInvoice(@RequestBody RequestInvoiceDTO newInvoice) {
        return invoiceService.saveInvoice(newInvoice);
    }

    @PutMapping("/invoices/{id}")
    Invoice editInvoice(@RequestBody RequestInvoiceDTO newInvoice,
                        @PathVariable UUID id) {
        return invoiceService.updateInvoice(newInvoice, id);
    }

    @DeleteMapping("/invoices/{id}")
    void deleteInvoice(@PathVariable UUID id) {
        invoiceService.deleteById(id);
    }

}
