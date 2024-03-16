package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.CustomerDTO;
import com.lab.labeli.form.CustomerForm;
import com.lab.labeli.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/lab/customer")
@RequiredArgsConstructor
public class CostumerController {
    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        final List<CustomerDTO> customersList = customerService.getAllCustomer();
        return ResponseEntity.ok().body(customersList);
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("customerId") final int customerId) throws Exception {
        final CustomerDTO customerDTOInfo = customerService.getCustomerById(customerId);
        return ResponseEntity.ok().body(customerDTOInfo);
    }

    @PostMapping("")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody @Valid final CustomerForm form) {
        final CustomerDTO saveCustomerInfo = customerService.createCustomer(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCustomerInfo);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") final int customerId) throws Exception {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody @Valid final CustomerForm customerInfo, @PathVariable("customerId") final int customerId) throws Exception {
        final CustomerDTO updateCustomerInfo = customerService.updateCustomer(customerInfo, customerId);
        return ResponseEntity.ok().body(updateCustomerInfo);
    }

}