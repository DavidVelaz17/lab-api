package com.lab.labeli.form;

import com.lab.labeli.entity.Status;
import lombok.Data;
import jakarta.validation.constraints.Size;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CustomerForm implements Serializable {
    @ApiObjectField(name= "name", description = "Customer's name")
    @Size (max = 100,message = "{right.length}")
    private String name;

    @ApiObjectField(name= "age", description = "Customer's age")
    @Size (max = 3,message = "{right.length}")
    private int age;

    @ApiObjectField(name= "phone_number", description = "Customer's phone number")
    @Size (max = 11,message = "{right.length}")
    private int phone_number;

    @ApiObjectField(name= "address", description = "Customer's address")
    @Size (max = 200,message = "{right.length}")
    private String address;

    @ApiObjectField(name= "date of birth", description = "Customer's date of birth")
    @Size (max = 50,message = "{right.length}")
    private LocalDate date_of_birth;

    @ApiObjectField(name= "status", description = "Customer's status")
    @Size (max = 2,message = "{right.length}")
    private Status status;
}
