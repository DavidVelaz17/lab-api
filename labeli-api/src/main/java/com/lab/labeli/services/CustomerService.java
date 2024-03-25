package com.lab.labeli.services;

import com.lab.labeli.dto.CustomerDTO;
import com.lab.labeli.entity.Customer;
import com.lab.labeli.form.CustomerForm;
import com.lab.labeli.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Value("${not.found}")
    private String notFound;

    public List<CustomerDTO> getAllCustomer() {
        final List<Customer> getAll = customerRepository.findAll();
        return getAll.stream().map(CustomerDTO::build).toList();
    }


    public CustomerDTO getCustomerById(final int idCustomer) throws Exception {
        validateIfCustomerExists(idCustomer);
        final Customer customer = customerRepository.findById(idCustomer).get();
        return CustomerDTO.build(customer);
    }

    public void deleteCustomer(final int idCustomer) throws Exception {
        validateIfCustomerExists(idCustomer);
        customerRepository.deleteById(idCustomer);
    }

    public CustomerDTO createCustomer(final CustomerForm form) {
        final Customer customer = new Customer(form);
        customerRepository.save(customer);
        return CustomerDTO.build(customer);
    }

    public CustomerDTO updateCustomer(final CustomerForm form, final int idCustomer) throws Exception {
        validateIfCustomerExists(idCustomer);
        final Customer customer = customerRepository.findById(idCustomer).get();
        customer.updateCustomer(form);
        customerRepository.save(customer);
        return CustomerDTO.build(customer);

    }

    private void validateIfCustomerExists(final int idCustomer) throws Exception{
        if(!customerRepository.existsById(idCustomer)){
            throw new Exception(notFound);
        }
    }

    public Map<Integer, CustomerDTO> getCustomersByIds(final List<Integer> customersIds){
        final List<Customer> customers = customerRepository.findAllById(customersIds);
        return customersDTOs(customers);
    }

    private Map<Integer, CustomerDTO> customersDTOs(final List<Customer> customers){
        final List<CustomerDTO> customerDTOS = customers.stream().map(CustomerDTO::build).toList();
        return customerDTOS.stream().collect(Collectors.toMap(CustomerDTO::getIdCustomer, Function.identity()));
    }
}
