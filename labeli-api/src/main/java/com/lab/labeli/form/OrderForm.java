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
    private Integer idCustomers;

    @ApiObjectField(name= "idUsers", description = "Users's id")
    @Positive
    private Integer idUsers;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiObjectField(name= "orderTimeStamp", description = "Order's Time Stamp")
    @Size(max = 45,message = "{right.length}")
    private LocalDate orderTimeStamp;

    @ApiObjectField(name= "orderAmountPaid", description = "Amount the customer payed with")
    @Positive
    private Double orderAmountPaid;

    @ApiObjectField(name= "orderChange", description = "Order's change")
    @Positive
    private Double orderChange;

    @ApiObjectField(name= "orderDeposit", description = "Order's deposit")
    @Positive
    private Double orderDeposit;

    @ApiObjectField(name= "orderTotal", description = "Order's total")
    @Positive
    private Double orderTotal;

    @ApiObjectField(name= "orderNotes", description = "Order's notes")
    @Size(max = 200,message = "{right.length}")
    private String orderNotes;

    @ApiObjectField(name= "orderReminding", description = "Order's reminding")
    @Positive
    private Double orderReminding;

}
