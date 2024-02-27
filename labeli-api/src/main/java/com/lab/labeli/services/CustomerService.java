package com.lab.labeli.services;

import com.lab.labeli.dto.CustomerDTO;
import com.lab.labeli.entity.Customer;
import com.lab.labeli.form.CustomerForm;
import com.lab.labeli.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
//@PropertySource("classpath:ValidationMessages.properties")
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomer() {
        final List<Customer> getAll = customerRepository.findAll();
        return getAll.stream().map(CustomerDTO::build).toList();
    }


    public CustomerDTO getCustomerById(final int idCustomer) {
        final Customer customer = customerRepository.findById(idCustomer).get();
        return CustomerDTO.build(customer);
    }

    public void deleteCustomer(final int idCustomer) {
        customerRepository.deleteById(idCustomer);
    }

    public CustomerDTO createCustomer(final CustomerForm form) {
        final Customer customer = new Customer(form);
        customerRepository.save(customer);
        return CustomerDTO.build(customer);
    }

    public CustomerDTO updateCustomer(final CustomerForm form, final int idCustomer) {
        final Customer customer = customerRepository.findById(idCustomer).get();
        customer.updateCustomer(form);
        customerRepository.save(customer);
        return CustomerDTO.build(customer);

    }
}
