package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.OrderDTO;
import com.lab.labeli.form.OrderForm;
import com.lab.labeli.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/lab/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        final List<OrderDTO> orderDTOList = orderService.getAllOrders();
        return ResponseEntity.ok().body(orderDTOList);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("orderId") final int orderId) throws Exception {
        final OrderDTO orderDTO = orderService.getOrderById(orderId);
        return ResponseEntity.ok().body(orderDTO);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrderByCustomerId(@PathVariable("customerId") final int customerId) {
        final List<OrderDTO> orderDTOList  = orderService.getOrderByCustomerId(customerId);
        return ResponseEntity.ok().body(orderDTOList);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody @Valid final OrderForm form) {
        final OrderDTO orderDTO = orderService.creteOrder(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable("orderId") final int orderId) throws Exception {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody @Valid final OrderForm form, @PathVariable("orderId") final int orderId) throws Exception {
        final OrderDTO orderDTO = orderService.updateOrder(form, orderId);
        return ResponseEntity.ok().body(orderDTO);
    }
}