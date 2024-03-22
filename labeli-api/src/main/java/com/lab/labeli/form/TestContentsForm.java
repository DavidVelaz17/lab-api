package com.lab.labeli.form;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;
import java.io.Serializable;

@Data
public class TestContentsForm implements Serializable {
    @ApiObjectField(name= "testId", description = "Identifier test")
    private int testId;

    @ApiObjectField(name= "contentId", description = "Identifier container")
    private int contentId;

}
