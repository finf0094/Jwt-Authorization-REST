package com.lombard.service.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contractStatus")
public class ContractStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
}
