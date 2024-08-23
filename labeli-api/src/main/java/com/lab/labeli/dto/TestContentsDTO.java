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

    @ApiObjectField(name= "testDTOResults", description = "Identifier test")
    private ContentsDTO contentsDTO;

    public static TestContentsDTO build(final TestContents testContents){
        return TestContentsDTO.builder()
                .testContentId(testContents.getIdTestContents())
                .testId(testContents.getTestsId())
                .contentId(testContents.getContentId())
                .build();
    }

    public static TestContentsDTO build(final TestContents testContents, final ContentsDTO contentsDTOResults){
        return TestContentsDTO.builder()
                .testContentId(testContents.getIdTestContents())
                .testId(testContents.getTestsId())
                .contentId(testContents.getContentId())
                .contentsDTO(contentsDTOResults)
                .build();
    }
}


