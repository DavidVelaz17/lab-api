package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.CustomerTestDTO;
import com.lab.labeli.form.CustomerTestForm;
import com.lab.labeli.services.CustomerTestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/alb/customertest")
public class CustomerTestController {
    private final CustomerTestService customerTestService;

    @GetMapping(path = "")
    public ResponseEntity<List<CustomerTestDTO>> getAllCustomerTestsList() {
        final List<CustomerTestDTO> cusrtomerTestList = customerTestService.getAllCustomersTest();
        return ResponseEntity.ok().body(cusrtomerTestList);
    }

    @GetMapping(path = "/{customerTestId}")
    public ResponseEntity<CustomerTestDTO> getCustomerTestById(@PathVariable("customerTestId") final int customerTestId) throws Exception {
        final CustomerTestDTO getCustomerTest = customerTestService.getCustomerTestById(customerTestId);
        return ResponseEntity.ok().body(getCustomerTest);
    }

    @PostMapping(path = "")
    public ResponseEntity<CustomerTestDTO> saveNewCustomerTest(@RequestBody @Valid final CustomerTestForm form) {
        final CustomerTestDTO saveCustomerTestInfo = customerTestService.createCustomerTest(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCustomerTestInfo);
    }

    @DeleteMapping(path = "/{customerTestId}")
    public ResponseEntity<Void> deleteCustomerTest(@PathVariable("customerTestId") final int customerTestId) throws Exception {
        customerTestService.deleteCustomerTest(customerTestId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{customerTestId}")
    public ResponseEntity<CustomerTestDTO> updateCustomerTest(@RequestBody @Valid final CustomerTestForm form, @PathVariable("customerTestId") final int customerTestId) throws Exception {
        final CustomerTestDTO updateCustomerTest = customerTestService.updateCustomerTest(form, customerTestId);
        return ResponseEntity.ok().body(updateCustomerTest);
    }

}
