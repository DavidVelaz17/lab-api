package com.lab.labeli.services;

import com.lab.labeli.dto.CustomerTestDTO;
import com.lab.labeli.entity.CustomerTest;
import com.lab.labeli.form.CustomerTestForm;
import com.lab.labeli.repository.CustomerTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath*:ValidationsMessages.properties")
public class CustomerTestService {
    private final CustomerTestRepository customerTestRepository;

    @Value("${not.found}")
    private String notFound;

    private void validateIfCustomerTestExists(final int idCustomerTest) throws Exception {
        if (!customerTestRepository.existsById(idCustomerTest)) {
            throw new Exception(notFound);
        }
    }

    public List<CustomerTestDTO> getAllCustomersTest() {
        final List<CustomerTest> getAllCostumersTest = customerTestRepository.findAll();
        return getAllCostumersTest.stream().map(CustomerTestDTO::build).toList();

    }

    public CustomerTestDTO getCustomerTestById(final int idCustomerTest) throws Exception {
        final CustomerTest customerTestById = customerTestRepository.findById(idCustomerTest).get();
        return CustomerTestDTO.build(customerTestById);
    }

    public CustomerTestDTO createCustomerTest(final CustomerTestForm form) {
        final CustomerTest createNewCustomerTest = new CustomerTest(form);
        customerTestRepository.save(createNewCustomerTest);
        return CustomerTestDTO.build(createNewCustomerTest);
    }


    public void deleteCustomerTest(final int idCustomerTest) throws Exception {
        validateIfCustomerTestExists(idCustomerTest);
        customerTestRepository.deleteById(idCustomerTest);
    }

    public CustomerTestDTO updateCustomerTest(final CustomerTestForm form, final Integer idCustomerTest) throws Exception {
        validateIfCustomerTestExists(idCustomerTest);
        final CustomerTest updateCustomerTestVariable = customerTestRepository.findById(idCustomerTest).get();
        updateCustomerTestVariable.updateCustomerTest(form);
        customerTestRepository.save(updateCustomerTestVariable);
        return CustomerTestDTO.build(updateCustomerTestVariable);

    }


}
