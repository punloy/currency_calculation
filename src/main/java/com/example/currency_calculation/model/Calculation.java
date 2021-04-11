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
}
