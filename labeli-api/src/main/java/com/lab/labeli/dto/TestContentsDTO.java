package com.lab.labeli.dto;
import com.lab.labeli.entity.TestContents;
import com.lab.labeli.entity.Status;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

import java.time.LocalDate;

@Getter
@Builder
public class TestContentsDTO {
    @ApiObjectField(name= "testId", description = "Identifier test")
    private int testId;

    @ApiObjectField(name= "contentId", description = "Identifier container")
    private int contentId;

    public static TestContentsDTO build(final TestContents customer){
        return TestContentsDTO.builder()
                .testId(customer.getTestsId())
                .contentId(customer.getContentId())
                .build();
    }
}


