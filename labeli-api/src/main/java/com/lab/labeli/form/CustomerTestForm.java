package com.lab.labeli.form;

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
}
