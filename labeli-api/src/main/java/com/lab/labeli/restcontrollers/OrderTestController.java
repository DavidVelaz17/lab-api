package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.OrderTestDTO;
import com.lab.labeli.form.OrderTestForm;
import com.lab.labeli.services.OrderTestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/lab/orderstest")
public class OrderTestController {
    private final OrderTestService orderTestService;

    @GetMapping(path = "")
    public ResponseEntity<List<OrderTestDTO>> getAllOrderTestList() {
        final List<OrderTestDTO> getOrderTestList = orderTestService.getAllOrderTest();
        return ResponseEntity.ok().body(getOrderTestList);
    }

    @GetMapping(path = "/{orderTestId}")
    public ResponseEntity<OrderTestDTO> getOrderTestById(@PathVariable("orderTestId") final int orderTestId) throws Exception {
        final OrderTestDTO getOrderTest = orderTestService.getOrderTestById(orderTestId);
        return ResponseEntity.ok().body(getOrderTest);
    }

    @PostMapping(path = "")
    public ResponseEntity<OrderTestDTO> saveOrderTest(@RequestBody @Valid final OrderTestForm form) {
        final OrderTestDTO saveOrderTest = orderTestService.createNewOrderTest(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveOrderTest);
    }

    @DeleteMapping(path = "/{orderTestId}")
    public ResponseEntity<Void> deleteOrdersTest(@PathVariable("orderTestId") final int orderTestId) throws Exception {
        orderTestService.deleteOrderTest(orderTestId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{orderTestId}")
    public ResponseEntity<OrderTestDTO> updateOrdersTest(@RequestBody @Valid final OrderTestForm form, @PathVariable("orderTestId") final int orderTestId) throws Exception {
        final OrderTestDTO updateOrderTest = orderTestService.updateOrderTestById(form, orderTestId);
        return ResponseEntity.ok().body(updateOrderTest);
    }

}
