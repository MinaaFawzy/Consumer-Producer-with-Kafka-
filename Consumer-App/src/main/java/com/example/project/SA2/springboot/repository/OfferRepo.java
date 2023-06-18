package com.example.project.SA2.springboot.repository;

import com.example.project.SA2.springboot.entity.OfferDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepo extends JpaRepository<OfferDb, Integer> {
}
