package com.ditod.acme.dto;

import java.util.List;

public record InvoiceFilteredPageableDTO(List<InvoiceFilteredDTO> invoices,
                                         Integer totalPages) {
}
