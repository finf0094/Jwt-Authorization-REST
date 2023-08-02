package com.lombard.service.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

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

}