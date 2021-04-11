package com.example.currency_calculation.controller;

//import com.example.currency_calculation.model.Calculation;
import com.example.currency_calculation.service.CalculationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class calculationController {
    @Autowired
    private CalculationService calculationService;

    @GetMapping("/health")
    public String hello(Model model) {
        model.addAttribute("health", "Hello world");
        return "health";
    }

    @GetMapping("/get")
    public ResponseEntity<?> getRate() {
        return this.calculationService.getRate();
    }

}
