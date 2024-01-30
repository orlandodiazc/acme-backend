package com.ditod.acme.repository;


import com.ditod.acme.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevenueRepository extends JpaRepository<Revenue, String> {
}
