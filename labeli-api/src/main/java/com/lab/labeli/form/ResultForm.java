package com.lab.labeli.form;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ResultForm implements Serializable {
    @ApiObjectField(name= "idCustomers", description = "Customer's id")
    @Positive
    private int idCustomers;

    @ApiObjectField(name= "idTests", description = "Test's id")
    @Positive
    private int idTests;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiObjectField(name= "resultTimeStamp", description = "Result's Time Stamp")
    private LocalDate resultTimeStamp;

    @ApiObjectField(name= "resultNote", description = "Result's Notes")
    @Size(max = 100,message = "{right.length}")
    private String resultNote;
}
