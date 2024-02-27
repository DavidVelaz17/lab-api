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

    @ApiObjectField(name = "phone_number", description = "Customer's ID")
    private String phone_number;

    @ApiObjectField(name = "address", description = "Customer's ID")
    private String address;

    @ApiObjectField(name = "date_of_birth", description = "Customer's ID")
    private LocalDate date_of_birth;

    @ApiObjectField(name = "status", description = "Customer's ID")
    private Status status;

    public static CustomerDTO build(final Customer customer){
        return CustomerDTO.builder()
                .idCustomer(customer.getIdCustomer())
                .name(customer.getName())
                .age(customer.getAge())
                .date_of_birth(customer.getDateOfBirth())
                .phone_number(customer.getPhoneNumber())
                .address(customer.getAddress())
                .status(customer.getStatus())
                .build();
    }
}
