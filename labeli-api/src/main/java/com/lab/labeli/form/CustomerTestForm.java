package com.lab.labeli.form;

import com.lab.labeli.entity.Status;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

@Data
public class CustomerTestForm implements Serializable {
    @ApiObjectField(name = "idCustomer", description = "Customer's id")
    private int idCustomer;

    @ApiObjectField(name = "idTest", description = "Test's id")
    private int idTest;

    @ApiObjectField(name= "status", description = "Customer's status")
    @Size (max = 2,message = "{right.length}")
    private Status status;
}
