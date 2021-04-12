package com.example.currency_calculation.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calculate_record")
public class Calculation {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency", length = 10, nullable = false, columnDefinition = "character varying(10)")
    private String currency;

    @Column(name = "rate", precision = 16, scale = 2)
    private Double rate;

    @Column(name = "price", precision = 16, scale = 2)
    private Double price;

    @Column(name = "discount", precision = 16, scale = 2)
    private Double discount;

    @Column(name = "result", precision = 16, scale = 2)
    private Double result;

    @Column(name = "record_time", columnDefinition = "TIMESTAMP with time zone DEFAULT ('now'::test)::TIMESTAMP with time zone ")
    private Timestamp recordTime;

    public Calculation(String currency, Double rate, Double price, Double discount, Double result,
            Timestamp recordTime) {
        this.currency = currency;
        this.rate = rate;
        this.price = price;
        this.discount = discount;
        this.result = result;
        this.recordTime = recordTime;
    }

    public Calculation() {
    }

    public Long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }
}
