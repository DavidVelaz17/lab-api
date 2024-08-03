package com.lab.labeli.dto;

import com.lab.labeli.entity.CustomerTest;
import com.lab.labeli.entity.Status;
import com.lab.labeli.entity.TestContents;
import lombok.Builder;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

import java.math.BigDecimal;

@Data
@Builder
public class CustomerTestDTO {
    @ApiObjectField(name = "idCustomersTests", description = "Customer test ID")
    private Integer idCustomersTests;

    @ApiObjectField(name = "idCustomer", description = "Customer's ID")
    private int idCustomer;

    @ApiObjectField(name = "idTest", description = "Customer's ID")
    private int idTest;

    @ApiObjectField(name= "testDTO", description = "Identifier test")
    private TestDTO testDTO;

    @ApiObjectField(name = "status", description = "Customer's ID")
    private Status status;

    @ApiObjectField(name = "priceByTest", description = "Customer's priceByTest")
    private BigDecimal priceByTest;

    public static CustomerTestDTO build(final CustomerTest customerTest) {
        return CustomerTestDTO.builder()
                .idCustomersTests(customerTest.getIdCustomersTests())
                .idCustomer(customerTest.getIdCustomers())
                .idTest(customerTest.getIdTest())
                .status(customerTest.getStatus())
                .priceByTest(customerTest.getPriceByTest())
                .build();
    }

    public static CustomerTestDTO build(final CustomerTest customerTest, final TestDTO testDTO){
        return CustomerTestDTO.builder()
                .idCustomersTests(customerTest.getIdCustomersTests())
                .idCustomer(customerTest.getIdCustomers())
                .idTest(customerTest.getIdTest())
                .testDTO(testDTO)
                .status(customerTest.getStatus())
                .priceByTest(customerTest.getPriceByTest())
                .build();
    }
}
