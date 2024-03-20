package com.lab.labeli.form;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

@Data
public class CustomerTestForm implements Serializable {

//TODO: Perhaps the size of the IDs will be a problem in the future as they grow and we have no control over them.

    @ApiObjectField(name = "idCustomer", description = "Customer's id")
//    @Size(max = 10, message = "{right.length}")
    private int idCustumer;


    @ApiObjectField(name = "idTest", description = "Test's id")
//    @Size(max = 10, message = "{right.length}")
    private int idTest;

}
