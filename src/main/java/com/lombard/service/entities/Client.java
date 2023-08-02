package com.lombard.service.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "\\d{12}")
    private String iin;

    @NotBlank
    private String fullname;

    @NotNull
    private Long passNumber;

    @Pattern(regexp = "\\+?[0-9]{11,12}")
    private String phone_number;

    @NotBlank
    private String city;

    @NotBlank
    private String address;

    @NotNull
    private Date birthDate;

    @NotNull
    private Date dateOfIssue;

    @Email(regexp = ".+@.+\\..+")
    private String email;
}