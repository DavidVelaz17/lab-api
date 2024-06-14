package com.lab.labeli.dto;
import com.lab.labeli.entity.Contents;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

@Getter
@Builder
public class ContentsDTO {
    @ApiObjectField(name= "contentId", description = "Contents's name")
    private int contentId;

    @ApiObjectField(name= "name", description = "Contents's name")
    private String name;

    @ApiObjectField(name= "referencesDTO", description = "References's DTO")
    private ReferencesDTO referencesDTO;

    public static ContentsDTO build(final Contents content){
        return ContentsDTO.builder()
                .contentId(content.getContentId())
                .name(content.getContentName())
                .build();
    }

    public static ContentsDTO build(final Contents content, final ReferencesDTO references){
        return ContentsDTO.builder()
                .contentId(content.getContentId())
                .name(content.getContentName())
                .referencesDTO(references)
                .build();
    }
}
