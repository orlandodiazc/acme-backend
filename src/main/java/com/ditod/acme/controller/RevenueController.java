package com.ditod.acme.controller;

import com.ditod.acme.model.Revenue;
import com.ditod.acme.repository.RevenueRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RevenueController {
    private final RevenueRepository repository;

    public RevenueController(RevenueRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/revenue")
    List<Revenue> all() {
        return repository.findAll();
    }
}
