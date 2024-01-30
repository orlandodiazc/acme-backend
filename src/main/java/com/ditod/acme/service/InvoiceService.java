package com.ditod.acme.service;

import com.ditod.acme.dto.InvoiceDetailsDTO;
import com.ditod.acme.dto.InvoiceFilteredDTO;
import com.ditod.acme.model.Invoice;
import com.ditod.acme.repository.InvoiceRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceService {
    private final InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public List<InvoiceDetailsDTO> findLatestInvoices() {
        Pageable pageable = PageRequest.of(0, 5);
        return repository.findLatestInvoices(pageable);
    }

    public List<InvoiceFilteredDTO> findFilteredInvoices(@RequestParam String query,
                                                         @RequestParam Integer currentPage) {
        Pageable pageable;
        if (currentPage < 1) {
            pageable = PageRequest.of(0, 6);
        } else {
            pageable = PageRequest.of(currentPage - 1, 6);
        }

        // return list for now then change it to page info
        return repository.findFilteredInvoices(query, pageable);
    }

    public Optional<Invoice> findInvoiceById(UUID id) {
        return repository.findById(id);
    }
}
