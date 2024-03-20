package com.lab.labeli.form;

import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

@Data
public class OrderTestForm implements Serializable {
    @ApiObjectField(name = "idOrderTest", description = "Id's order test")
    private int idOrderTest;

    @ApiObjectField(name = "idOrder", description = "Id's order")
    private int idOrder;

    @ApiObjectField(name = "idTest", description = "Id's test")
    private int idTest;

}
