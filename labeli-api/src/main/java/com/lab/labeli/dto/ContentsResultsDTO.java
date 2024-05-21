package com.lab.labeli.dto;
import com.lab.labeli.entity.ContentsResults;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

@Getter
@Builder
public class ContentsResultsDTO {
    @ApiObjectField(name= "contentResultId", description = "Content Result Id")
    private int contResultId;

    @ApiObjectField(name= "resultId", description = "Result Id")
    private int resultId;

    @ApiObjectField(name= "contentId", description = "Content Ids")
    private int contentId;

    @ApiObjectField(name= "resultValue", description = "Result value")
    @Size(max = 100,message = "{right.length}")
    private String resValue;

    public static ContentsResultsDTO build(final ContentsResults content){
        return ContentsResultsDTO.builder()
                .contResultId(content.getContentResultId())
                .resultId(content.getResultId())
                .contentId(content.getContentId())
                .resValue(content.getResultValue())
                .build();
    }
}
