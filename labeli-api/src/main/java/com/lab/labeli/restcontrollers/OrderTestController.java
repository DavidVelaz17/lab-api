package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.CustomerDTO;
import com.lab.labeli.dto.OrderTestDTO;
import com.lab.labeli.form.CustomerForm;
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
@RequestMapping(path = "/lab/ordertest")
public class OrderTestController {
    private final OrderTestService orderTestService;

    @GetMapping(path = "")
    public ResponseEntity<List<OrderTestDTO>> getAllOrderTest() {
        final List<OrderTestDTO> orderTestList = orderTestService.getAllOrderTest();
        return ResponseEntity.ok().body(orderTestList);
    }

    @GetMapping("/{orderTestId}")
    public ResponseEntity<OrderTestDTO> getOrderTestById(@PathVariable("orderTestId") final int orderTestId) throws Exception {
        final OrderTestDTO orderTestBody = orderTestService.getOrderTestById(orderTestId);
        return ResponseEntity.ok().body(orderTestBody);
    }

    @PostMapping("")
    public ResponseEntity<OrderTestDTO> saveNewOrderTest(@RequestBody @Valid final OrderTestForm form) {
        final OrderTestDTO saveOrderTest = orderTestService.createNewOrderTest(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveOrderTest);
    }

    @DeleteMapping("/{orderTestId}")
    public ResponseEntity<Void> deleteOrderTest(@PathVariable("orderTestId") final int orderTestId) throws Exception {
        orderTestService.deleteOrderTest(orderTestId);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{orderTestId}")
    public ResponseEntity<OrderTestDTO> updateOrderTestById(@RequestBody @Valid final OrderTestForm formOrderTest, @PathVariable("orderTestId") final int orderTestId) throws Exception {
        final OrderTestDTO updateOrderTest = orderTestService.updateOrderTestById(formOrderTest, orderTestId);
        return ResponseEntity.ok().body(updateOrderTest);
    }

}
