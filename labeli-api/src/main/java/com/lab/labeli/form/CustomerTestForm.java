package com.lab.labeli.form;

import com.lab.labeli.entity.Status;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CustomerTestForm implements Serializable {
    @ApiObjectField(name = "idCustomer", description = "Customer's id")
    private Integer idCustomer;

    @ApiObjectField(name = "idTest", description = "Test's id")
    private Integer idTest;

    @ApiObjectField(name= "status", description = "Customer's status")
    @Size (max = 2,message = "{right.length}")
    private Status status;

    @ApiObjectField(name = "priceByTest", description = "price by test")
    private BigDecimal priceByTest;
}
