package com.lab.labeli.form;
import com.lab.labeli.entity.Status;
import lombok.Data;
import jakarta.validation.constraints.Size;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ContentsForm implements Serializable {
    @ApiObjectField(name= "name", description = "Contents's name")
    @Size (max = 100,message = "{right.length}")
    private String name;
}
