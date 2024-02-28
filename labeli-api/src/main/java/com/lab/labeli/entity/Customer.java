package com.lab.labeli.entity;

import com.lab.labeli.convertos.StatusConvertor;
import com.lab.labeli.form.CustomerForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "customers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private int idcustomers;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "date_of_birth ", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "status", nullable = false)
    @Convert(converter = StatusConvertor.class)
    private Status status;

    public Customer(final CustomerForm form){
        this.name = form.getName();
        this.age=form.getAge();
        this.phoneNumber=form.getPhoneNumber();
        this.address=form.getAddress();
        this.dateOfBirth=form.getDateOfBirth();
        this.status=form.getStatus();
    }

    public void updateCustomer(final CustomerForm form){
        this.name= form.getName();
        this.age=form.getAge();
        this.phoneNumber=form.getPhoneNumber();
        this.address=form.getAddress();
        this.dateOfBirth=form.getDateOfBirth();
        this.status=form.getStatus();
    }
}
