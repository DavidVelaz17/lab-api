package com.lab.labeli.entity;

import com.lab.labeli.convertors.StatusConvertor;
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
    @Column(name = "idcustomers",nullable = false,unique = true)
    private int idCustomers;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "customer_age", nullable = false)
    private int age;

    @Column(name = "customer_phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "customer_address", nullable = false)
    private String address;

    @Column(name = "customer_date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "customer_doctor_name", nullable = false)
    private String doctorName;


    public Customer(final CustomerForm form){
        this.name = form.getName();
        this.age=form.getAge();
        this.phoneNumber=form.getPhoneNumber();
        this.address=form.getAddress();
        this.dateOfBirth=form.getDateOfBirth();
        this.doctorName=form.getDoctorName();
    }

    public void updateCustomer(final CustomerForm form){
        this.name= form.getName();
        this.age=form.getAge();
        this.phoneNumber=form.getPhoneNumber();
        this.address=form.getAddress();
        this.dateOfBirth=form.getDateOfBirth();
        this.doctorName=form.getDoctorName();
    }
}
