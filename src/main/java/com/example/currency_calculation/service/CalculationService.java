package com.example.currency_calculation.service;

import com.example.currency_calculation.repository.CalculationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    @Autowired
    private CalculationRepository calculationRepository;

    public ResponseEntity<?> getRate() {
        long c = calculationRepository.count();
        System.out.println(c);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
