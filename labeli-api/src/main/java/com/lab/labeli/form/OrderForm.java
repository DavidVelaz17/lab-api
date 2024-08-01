package com.lab.labeli.form;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class OrderForm implements Serializable {
    @ApiObjectField(name= "idCustomers", description = "Customer's id")
    @Positive
    private int idCustomers;

    @ApiObjectField(name= "idUsers", description = "Users's id")
    @Positive
    private int idUsers;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiObjectField(name= "orderTimeStamp", description = "Order's Time Stamp")
    @Size(max = 45,message = "{right.length}")
    private LocalDate orderTimeStamp;

    @ApiObjectField(name= "orderAmountPaid", description = "Amount the customer payed with")
    @Positive
    private double orderAmountPaid;

    @ApiObjectField(name= "orderChange", description = "Order's change")
    @Positive
    private double orderChange;

    @ApiObjectField(name= "orderDeposit", description = "Order's deposit")
    @Positive
    private double orderDeposit;

    @ApiObjectField(name= "orderTotal", description = "Order's total")
    @Positive
    private double orderTotal;

    @ApiObjectField(name= "orderNotes", description = "Order's notes")
    @Size(max = 200,message = "{right.length}")
    private String orderNotes;
}
