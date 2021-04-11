package com.example.currency_calculation.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import com.example.currency_calculation.model.Calculation;
import com.example.currency_calculation.repository.CalculationRepository;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    @Autowired
    private CalculationRepository calculationRepository;

    public Double rate = 0.0;
    public String currency = "";

    public String getCurl(String url) {
        String command = "curl -X GET " + url;
        try {
            Process process = Runtime.getRuntime().exec(command);
            String result = new BufferedReader(new InputStreamReader(process.getInputStream())).lines()
                    .collect(Collectors.joining("\n"));
            process.destroy();

            return result;

        } catch (IOException e) {
            e.printStackTrace();

            return "{\"result\":{\"status\":\"failed\"}}";
        }
    }

    public void getExrate(String target) {

        JSONObject obj = new JSONObject(target);
        obj.keySet().forEach(value -> {
            switch (value) {
            case "USDUSD":
                Object exrate = obj.getJSONObject(value).get("Exrate");
                rate = ((Number) exrate).doubleValue();
                currency = value;
                break;
            case "USDTWD":
                exrate = obj.getJSONObject(value).get("Exrate");
                rate = ((Number) exrate).doubleValue();
                currency = value;
                break;
            case "USDJPY":
                exrate = obj.getJSONObject(value).get("Exrate");
                rate = ((Number) exrate).doubleValue();
                currency = value;
                break;

            default:
                break;
            }
        });
    }

    public ResponseEntity<?> getRate() {

        String url = "https://tw.rter.info/capi.php";
        String target = getCurl(url);
        getExrate(target);

        long c = calculationRepository.count();
        System.out.println(c);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public Double putResult(String tarCurrency, Double price, Double discount) {
        double result = 0.0;
        return result;
    }

}
