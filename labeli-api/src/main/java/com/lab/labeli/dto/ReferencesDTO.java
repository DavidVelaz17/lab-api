package com.lab.labeli.dto;

import com.lab.labeli.entity.References;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

@Getter
@Builder
public class ReferencesDTO {
    @ApiObjectField(name= "referencesId", description = "References's Id")
    private int referencesId;

    @ApiObjectField(name= "contentId", description = "Contents's Id")
    private int contentId;

    @ApiObjectField(name= "vRefText", description = "Reference Value in Text")
    private String vRefText;

    @ApiObjectField(name= "vMax", description = "Maximum Reference Value")
    private String vMax;

    @ApiObjectField(name= "vMin", description = "Minimum Reference Value")
    private String vMin;

    public static ReferencesDTO build(final References references){
        return ReferencesDTO.builder()
                .referencesId(references.getReferencesId())
                .contentId(references.getContentId())
                .vRefText(references.getVRefText())
                .vMax(references.getVMax())
                .vMin(references.getVMin())
                .build();
    }
}
