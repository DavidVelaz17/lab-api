package com.lab.labeli.dto;
import com.lab.labeli.entity.TestContents;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;
@Getter
@Builder
public class TestContentsDTO {
    @ApiObjectField(name= "test_content_id", description = "Identifier test")
    private int testContentId;

    @ApiObjectField(name= "testId", description = "Identifier test")
    private int testId;

    @ApiObjectField(name= "contentId", description = "Identifier container")
    private int contentId;

    public static TestContentsDTO build(final TestContents testContents){
        return TestContentsDTO.builder()
                .testContentId(testContents.getIdTestContents())
                .testId(testContents.getTestsId())
                .contentId(testContents.getContentId())
                .build();
    }
}


