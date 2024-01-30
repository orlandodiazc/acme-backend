package com.ditod.acme.controller;

import com.ditod.acme.dto.CustomerFilteredDTO;
import com.ditod.acme.dto.CustomerSimpleDTO;
import com.ditod.acme.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers/base")
    List<CustomerSimpleDTO> all() {
        return repository.findSimpleAll();
    }

    @GetMapping("/customers")
    List<CustomerFilteredDTO> findByQuery(@RequestParam(required = false, defaultValue
            = "") String query) {
        return repository.findFilteredCustomers(query);
    }
}
