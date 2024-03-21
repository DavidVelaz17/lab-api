package com.lab.labeli.dto;

import com.lab.labeli.entity.Customer;
import com.lab.labeli.entity.Status;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

import java.time.LocalDate;

@Getter
@Builder
public class CustomerDTO {
    @ApiObjectField(name = "idCustomer", description = "Customer's ID")
    private int idCustomer;

    @ApiObjectField(name = "name", description = "Customer's ID")
    private String name;

    @ApiObjectField(name = "age", description = "Customer's ID")
    private int age;

    @ApiObjectField(name = "phoneNumber", description = "Customer's ID")
    private String phoneNumber;

    @ApiObjectField(name = "address", description = "Customer's ID")
    private String address;

    @ApiObjectField(name = "dateOfBirth", description = "Customer's ID")
    private LocalDate dateOfBirth;

    @ApiObjectField(name = "status", description = "Customer's ID")
    private Status status;

    @ApiObjectField(name= "pdfTimestamp", description = "PDF's timestamp")
    private LocalDate pdfTimestamp;

    @ApiObjectField(name= "doctorName", description = "Doctor's name")
    private String doctorName;

    @ApiObjectField(name= "idTests", description = "Test's id")
    private int idTests;

    @ApiObjectField(name= "notes", description = "Customer's notes")
    private String notes;

    public static CustomerDTO build(final Customer customer){
        return CustomerDTO.builder()
                .idCustomer(customer.getIdCustomers())
                .name(customer.getName())
                .age(customer.getAge())
                .dateOfBirth(customer.getDateOfBirth())
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .status(customer.getStatus())
                .pdfTimestamp(customer.getPdfTimestamp())
                .doctorName(customer.getDoctorName())
                .idTests(customer.getIdTests())
                .notes(customer.getNotes())
                .build();
    }
}
