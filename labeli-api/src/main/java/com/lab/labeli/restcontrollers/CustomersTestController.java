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
@RequestMapping(path = "lab/customer/test")
public class CustomersTestController {
    private final CustomerTestService customerTestServicel;

    @GetMapping(path = "")
    public ResponseEntity<List<CustomerTestDTO>> getAllCustomerTestList() {
        final List<CustomerTestDTO> getAllCustomersTest = customerTestServicel.getAllCustomersTest();
        return ResponseEntity.ok().body(getAllCustomersTest);
    }

    @GetMapping("/{customerTestId}")
    public ResponseEntity<CustomerTestDTO> getCustomerTestById(@PathVariable("customerTestId") final int customerTestId) throws Exception {
        final CustomerTestDTO getCustomerTestById = customerTestServicel.getCustomerTestById(customerTestId);
        return ResponseEntity.ok().body(getCustomerTestById);
    }

    @PostMapping("")
    public ResponseEntity<CustomerTestDTO> saveCustomerTest(@RequestBody @Valid final CustomerTestForm form) {
        final CustomerTestDTO saveCustomerTest = customerTestServicel.createCustomerTest(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCustomerTest);
    }

    @DeleteMapping("/{customerTestId}")
    public ResponseEntity<Void> deleteCustomerTest(@PathVariable("customerTestId") final int customerTestId) throws Exception {
        customerTestServicel.deleteCustomerTest(customerTestId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{customerTestId}")
    public ResponseEntity<CustomerTestDTO> updateCustomerTest(@RequestBody @Valid final CustomerTestForm customerTestInfo, @PathVariable("customerTestId") final int customerTestId) throws Exception {
        final CustomerTestDTO updateCustomerTestInfo = customerTestServicel.updateCustomerTest(customerTestInfo, customerTestId);
        return ResponseEntity.ok().body(updateCustomerTestInfo);
    }
}
