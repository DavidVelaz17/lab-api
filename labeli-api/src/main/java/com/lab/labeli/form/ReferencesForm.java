package com.lab.labeli.form;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

@Data
public class ReferencesForm implements Serializable {
    @ApiObjectField(name= "contentId", description = "Contents's Id")
    private int contentId;

    @ApiObjectField(name= "vRefText", description = "Reference Value in Text")
    @Size(max = 500,message = "{right.length}")
    private String vRefText;

    @ApiObjectField(name= "vMax", description = "Maximum Reference Value")
    private String vMax;

    @ApiObjectField(name= "vMin", description = "Minimum Reference Value")
    private String vMin;
}
