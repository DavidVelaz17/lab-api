package com.lab.labeli.dto;

import com.lab.labeli.entity.Order;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

import java.time.LocalDate;

@Getter
@Builder
public class OrderDTO {
    @ApiObjectField(name = "idOrders", description = "Order's ID")
    private int idOrders;

    @ApiObjectField(name = "idCustomers", description = "Customer's ID")
    private int idCustomers;

    @ApiObjectField(name = "idUsers", description = "User's ID")
    private int idUsers;

    @ApiObjectField(name = "orderTimeStamp", description = "Order's Time Stamp")
    private LocalDate orderTimeStamp;

    @ApiObjectField(name = "orderDeposit", description = "Order's Deposit")
    private double orderDeposit;

    @ApiObjectField(name = "orderTotal", description = "Order's Total")
    private double orderTotal;

    @ApiObjectField(name = "orderNotes", description = "Order's Notes")
    private String orderNotes;

    public static OrderDTO build(final Order order){
        return OrderDTO.builder()
                .idOrders(order.getIdOrders())
                .idCustomers(order.getIdCustomers())
                .idUsers(order.getIdUsers())
                .orderTimeStamp(order.getOrderTimeStamp())
                .orderDeposit(order.getOrderDeposit())
                .orderTotal(order.getOrderTotal())
                .orderNotes(order.getOrderNotes())
                .build();
    }
}
