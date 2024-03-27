package com.lab.labeli.form;

import com.lab.labeli.entity.Status;
import lombok.Data;
import jakarta.validation.constraints.Size;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ContentsResultsForm implements Serializable {
    @ApiObjectField(name= "resultId", description = "Result Id")
    private int resultId;

    @ApiObjectField(name= "contentId", description = "Content Ids")
    private int contentId;

    @ApiObjectField(name= "resultValue", description = "Result value")
    @Size (max = 100,message = "{right.length}")
    private String resultValue;

}
