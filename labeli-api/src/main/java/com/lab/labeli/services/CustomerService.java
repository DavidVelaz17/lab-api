package com.lab.labeli.services;

import com.lab.labeli.dto.CustomerDTO;
import com.lab.labeli.entity.Customer;
import com.lab.labeli.form.CustomerForm;
import com.lab.labeli.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationMessages.properties")
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDTO getCustomerById(final int idCustomer){
        final Customer customer = customerRepository.findById(idCustomer).get();
        return CustomerDTO.build(customer);
    }

    public void deleteCustomer(final int idCustomer){
        customerRepository.deleteById(idCustomer);
    }

    public CustomerDTO createCustomer(final CustomerForm form){
        final Customer customer = new Customer(form);
        customerRepository.save(customer);
        return CustomerDTO.build(customer);
    }

    public CustomerDTO updateCustomer(final CustomerForm form, final int idCustomer){
        final Customer customer = customerRepository.findById(idCustomer).get();
        customer.updateCustomer(form);
        customerRepository.save(customer);
        return CustomerDTO.build(customer);

    }
}
