package com.lab.labeli.dto;

import com.lab.labeli.entity.OrderTest;
import lombok.Builder;
import lombok.Data;
import org.jsondoc.core.annotation.ApiObjectField;

@Data
@Builder
public class OrderTestDTO {
    @ApiObjectField(name = "idOrderTest", description = "Order test's ID")
    private int idOrderTest;

    @ApiObjectField(name = "idOrder", description = "Order's ID")
    private int idOrder;

    @ApiObjectField(name = "idTest", description = "Test's ID")
    private int idTest;

    public static OrderTestDTO build(final OrderTest orderTest) {
        return OrderTestDTO.builder()
                .idOrderTest(orderTest.getIdOrderTest())
                .idOrder(orderTest.getIdOrder())
                .idTest(orderTest.getIdTest())
                .build();
    }
}
