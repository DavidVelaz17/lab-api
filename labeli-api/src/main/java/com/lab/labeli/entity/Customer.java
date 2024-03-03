package com.lab.labeli.entity;

import com.lab.labeli.convertors.StatusConvertor;
import com.lab.labeli.convertors.TestsConvertor;
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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "status", nullable = false)
    @Convert(converter = StatusConvertor.class)
    private Status status;

    @Column(name = "pdf_timestamp", nullable = false)
    private LocalDate pdfTimestamp;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

    @Column(name = "idtests", nullable = false)
    @Convert(converter = TestsConvertor.class)
    private Tests idTests;

    @Column(name = "notes", nullable = false)
    private String notes;

    public Customer(final CustomerForm form){
        this.name = form.getName();
        this.age=form.getAge();
        this.phoneNumber=form.getPhoneNumber();
        this.address=form.getAddress();
        this.dateOfBirth=form.getDateOfBirth();
        this.status=form.getStatus();
        this.pdfTimestamp=form.getPdfTimestamp();
        this.doctorName=form.getDoctorName();
        this.idTests=form.getIdTests();
        this.notes=form.getName();
    }

    public void updateCustomer(final CustomerForm form){
        this.name= form.getName();
        this.age=form.getAge();
        this.phoneNumber=form.getPhoneNumber();
        this.address=form.getAddress();
        this.dateOfBirth=form.getDateOfBirth();
        this.status=form.getStatus();
        this.pdfTimestamp=form.getPdfTimestamp();
        this.doctorName=form.getDoctorName();
        this.idTests=form.getIdTests();
        this.notes=form.getName();
    }
}
