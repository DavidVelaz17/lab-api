package com.lab.labeli.dto;

import com.lab.labeli.entity.Test;
import lombok.Builder;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

@Data
@Builder
public class TestDTO {
    @ApiObjectField(name = "idTest", description = "Test's ID")
    private int idTest;

    @ApiObjectField(name = "testName", description = "Test's name")
    private String testName;

    @ApiObjectField(name = "testPrice", description = "Test's price")
    private Double testPrice;

    @ApiObjectField(name = "testPriceWithDiscount", description = "Test Price With Discount")
    private Double testPriceWithDiscount;

    public static TestDTO build(final Test testSendInfo) {
        return TestDTO.builder()
                .idTest(testSendInfo.getIdTest())
                .testName(testSendInfo.getTestName())
                .testPrice(testSendInfo.getTestPrice())
                .testPriceWithDiscount(testSendInfo.getTestPriceWithDiscount())
                .build();
    }
}
