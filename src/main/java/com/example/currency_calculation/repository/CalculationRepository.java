package com.example.currency_calculation.repository;

import com.example.currency_calculation.model.Calculation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Long> {

}
