package com.ditod.acme.controller;

import com.ditod.acme.dto.OverviewStatsDTO;
import com.ditod.acme.service.OverviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OverviewController {

    private final OverviewService overviewService;

    public OverviewController(OverviewService overviewService) {
        this.overviewService = overviewService;
    }

    @GetMapping("/overview/stats")
    OverviewStatsDTO overviewStats() {
        return overviewService.findOverviewStats();
    }

}
