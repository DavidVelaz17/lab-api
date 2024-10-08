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

    //This line was commented to update a testContent and only make use of resultValue
    @ApiObjectField(name= "resultId", description = "Result Id")
    private Integer resultId;

    @ApiObjectField(name= "contentId", description = "Content Ids")
    private Integer contentId;

    @ApiObjectField(name= "resultValue", description = "Result value")
    @Size (max = 100,message = "{right.length}")
    private String resultValue;

}
