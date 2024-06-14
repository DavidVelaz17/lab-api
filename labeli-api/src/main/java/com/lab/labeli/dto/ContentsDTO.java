package com.lab.labeli.dto;
import com.lab.labeli.entity.Contents;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

@Getter
@Builder
public class ContentsDTO {
    @ApiObjectField(name= "contentId", description = "Content's name")
    private int contentId;

    @ApiObjectField(name= "name", description = "Content's name")
    private String name;

    @ApiObjectField(name= "units", description = "Contents units")
    private String units;

    @ApiObjectField(name= "referencesDTO", description = "Reference's DTO")
    private ReferencesDTO referencesDTO;

    public static ContentsDTO build(final Contents content){
        return ContentsDTO.builder()
                .contentId(content.getContentId())
                .name(content.getContentName())
                .units(content.getContentUnits())
                .build();
    }

    public static ContentsDTO build(final Contents content, final ReferencesDTO references){
        return ContentsDTO.builder()
                .contentId(content.getContentId())
                .name(content.getContentName())
                .units(content.getContentUnits())
                .referencesDTO(references)
                .build();
    }
}
