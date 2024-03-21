package com.lab.labeli.form;

import com.lab.labeli.entity.Status;
import lombok.Data;
import jakarta.validation.constraints.Size;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.format.annotation.DateTimeFormat;

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

    @ApiObjectField(name = "phoneNumber", description = "Customer's phone number")
    @Size(max = 13, message = "{phoneNumber.right.length}")
    private String phoneNumber;

    @ApiObjectField(name= "address", description = "Customer's address")
    @Size (max = 200,message = "{right.length}")
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiObjectField(name = "dateOfBirth", description = "Customer's birthday", required = true)
    private LocalDate dateOfBirth;

    @ApiObjectField(name= "status", description = "Customer's status")
    @Size (max = 2,message = "{right.length}")
    private Status status;

    @ApiObjectField(name= "doctorName", description = "Doctor's name")
    @Size (max = 100,message = "{right.length}")
    private String doctorName;
}
