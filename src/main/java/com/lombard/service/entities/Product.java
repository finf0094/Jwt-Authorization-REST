package com.lombard.service.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "condition")
    private String condition;

    @NotBlank
    @Column(name = "product_type")
    private String productType;

    @NotBlank
    @Column(name = "category")
    private String category;

    @NotBlank
    @Column(name = "model")
    private String model;

    @NotBlank
    @Column(name = "memory")
    private String memory;

    @Column(name = "packaging")
    private boolean packaging;

    @Column(name = "serial_number")
    private String serialNumber;

    @NotNull
    @Column(name = "imei")
    private Long imei;

    @NotBlank
    @Column(name = "description")
    private String description;

    @NotNull
    @Min(value = 1)
    @Column(name = "days")
    private Integer days;

    @NotNull
    @Column(name = "sum")
    private Double sum;

    @NotNull
    @Column(name = "confirm_sum")
    private Double confirmSum;

    @Temporal(TemporalType.DATE)
    @Column(name = "today")
    private Date today = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "last_payment_date")
    private Date lastPaymentDate;

    @NotNull
    @Column(name = "sum_to_buyout")
    private Double sumToBuyout;

    public void calculateLastPaymentDate() {
        if (today != null && days != null) {
            // Convert days to milliseconds and add it to today's time
            long daysInMillis = days * 24L * 60 * 60 * 1000;
            long lastPaymentDateInMillis = today.getTime() + daysInMillis;
            lastPaymentDate = new Date(lastPaymentDateInMillis);
        } else {
            lastPaymentDate = null;
        }
    }

    public void calculateUpdatedSums() {
        if (today != null && days != null && sum != null) {
            today = new Date();
            long oneDayInMillis = 24L * 60 * 60 * 1000;
            long todayInMillis = today.getTime();
            long currentMillis = new Date().getTime();
            long daysPassed = (currentMillis - todayInMillis) / oneDayInMillis;

            double interestRatePerDay = 0.01; // 1% interest rate per day
            double totalInterest = sum * interestRatePerDay * daysPassed;
            double updatedSumToBuyout = sum + totalInterest;
            setSumToBuyout(updatedSumToBuyout);
        }
    }
}

