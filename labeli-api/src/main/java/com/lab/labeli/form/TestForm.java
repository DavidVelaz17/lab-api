package com.lab.labeli.form;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

@Data
public class TestForm implements Serializable {

    @ApiObjectField(name = "test_name", description = "Test's name")
    @Size(max = 100, message = "{right.length}")
    private String testName;

    @ApiObjectField(name = "testPrice", description = "Test price")
    private Double testPrice;

    @ApiObjectField(name = "testPriceWithDiscount", description = "Test price with discount")
    private Double testPriceWithDiscount;

}
