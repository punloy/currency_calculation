package com.example.currency_calculation.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

import com.example.currency_calculation.model.Calculation;
import com.example.currency_calculation.repository.CalculationRepository;

import org.json.JSONObject;
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

    public Double getExrate(String exCurrency, String target) {

        rate = 0.0;
        currency = "USD" + exCurrency;

        JSONObject obj = new JSONObject(target);
        obj.keySet().forEach(value -> {

            if (value.equals(currency)) {
                Object exrate = obj.getJSONObject(value).get("Exrate");
                rate = ((Number) exrate).doubleValue();
            }
        });

        return rate;
    }

    public ResponseEntity<?> getRate(String exCurrency, Double price, Double discount) {

        currency = exCurrency;

        String url = "https://tw.rter.info/capi.php";
        String target = getCurl(url);

        rate = getExrate(exCurrency, target);

        Double result = null;
        if (exCurrency != "TWD") {
            discount = 0.0;
        }
        result = price * rate;

        Timestamp recordTime = Timestamp.from(ZonedDateTime.now().toInstant());
        Calculation calculation = new Calculation(currency, rate, price, discount, result, recordTime);
        calculationRepository.save(calculation);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
