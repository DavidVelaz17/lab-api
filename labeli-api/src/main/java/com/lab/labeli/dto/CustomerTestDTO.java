package com.lab.labeli.dto;

import com.lab.labeli.entity.CustomerTest;
import lombok.Builder;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

@Data
@Builder
public class CustomerTestDTO {
    @ApiObjectField(name = "idCustomersTests", description = "Customer test ID")
    private Integer idCustomersTests;

    @ApiObjectField(name = "idCustomer", description = "Customer's ID")
    private int idCustomer;

    @ApiObjectField(name = "idTest", description = "Customer's ID")
    private int idTest;

    public static CustomerTestDTO build(final CustomerTest customerTest) {
        return CustomerTestDTO.builder()
                .idCustomersTests(customerTest.getIdCustomersTests())
                .idCustomer(customerTest.getIdCustomersTests())
                .idTest(customerTest.getIdTest())
                .build();
    }
}
