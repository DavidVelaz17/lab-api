package com.lab.labeli.dto;

import com.lab.labeli.entity.Result;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

import java.time.LocalDate;

@Getter
@Builder
public class ResultDTO {
    @ApiObjectField(name = "idResults", description = "Result's id")
    private int idResults;
    @ApiObjectField(name = "idCustomers", description = "Customer's id")
    private int idCustomers;

    @ApiObjectField(name = "idTests", description = "Test's id")
    private int idTests;

    @ApiObjectField(name = "resultTimeStamp", description = "Result's Time Stamp")
    private LocalDate resultTimeStamp;

    @ApiObjectField(name = "resultNote", description = "Result's Notes")
    private String resultNote;

    @ApiObjectField(name = "contentResult", description = "ContentResult's data")
    private ContentsResultsDTO contentsResultsInfo;

    public static ResultDTO build(final Result result) {
        return ResultDTO.builder()
                .idResults(result.getIdResults())
                .idCustomers(result.getIdCustomers())
                .idTests(result.getIdTests())
                .resultTimeStamp(result.getResultTimeStamp())
                .resultNote(result.getResultNote())
                .build();
    }

    public static ResultDTO build(final Result result, final ContentsResultsDTO contResults) {
        return ResultDTO.builder()
                .idResults(result.getIdResults())
                .idCustomers(result.getIdCustomers())
                .idTests(result.getIdTests())
                .resultTimeStamp(result.getResultTimeStamp())
                .resultNote(result.getResultNote())
                .contentsResultsInfo(contResults)
                .build();
    }
}
