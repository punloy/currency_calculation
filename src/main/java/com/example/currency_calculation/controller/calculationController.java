package com.example.currency_calculation.controller;

import com.example.currency_calculation.service.CalculationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class calculationController {
    @Autowired
    private CalculationService calculationService;

    @GetMapping("/health")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getRate(@RequestParam(value = "currency", defaultValue = "USD") String currency,
            @RequestParam(value = "price") Double price, @RequestParam(value = "discount") Double discount) {
        return this.calculationService.getRate(currency, price, discount);
    }
}
