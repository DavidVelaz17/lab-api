package com.lab.labeli.services;

import com.lab.labeli.dto.CustomerTestDTO;
import com.lab.labeli.dto.TestContentsDTO;
import com.lab.labeli.dto.TestDTO;
import com.lab.labeli.entity.CustomerTest;
import com.lab.labeli.entity.TestContents;
import com.lab.labeli.form.CustomerTestForm;
import com.lab.labeli.repository.CustomerTestRepository;
import com.lab.labeli.repository.TestContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@PropertySource("classpath*:ValidationsMessages.properties")
public class CustomerTestService {
    private final CustomerTestRepository customerTestRepository;
    private final TestService testService;
    @Value("${not.found}")
    private String notFound;

    private void validateIfCustomerTestExists(final int idCustomerTest) throws Exception {
        if (!customerTestRepository.existsById(idCustomerTest)) {
            throw new Exception(notFound);
        }
    }

    private Map<Integer, TestDTO> getTestIdsMap(final List<Integer> contentsId) {
        return testService.getIdListByTest(contentsId);
    }

    public List<CustomerTestDTO> getAllCustomersTest() {
        final List<CustomerTest> getAllIdTest = customerTestRepository.findAll();
        final Map<Integer, TestDTO> contTestContentsListId = getTestIdsMap(getAllIdTest.stream().map(CustomerTest::getIdTest).toList());
        return getAllIdTest.stream().map(customersTest -> CustomerTestDTO.build(customersTest, contTestContentsListId.get(customersTest.getIdTest()))).toList();

    }

    public List<CustomerTestDTO> getCustomerTestByCustomerId(final int idCustomer) throws Exception {

        final List<CustomerTest> getAllIdTest = customerTestRepository.findAllByIdCustomers(idCustomer);
        final Map<Integer, TestDTO> contTestContentsListId = getTestIdsMap(getAllIdTest.stream().map(CustomerTest::getIdTest).toList());
        return getAllIdTest.stream().map(customersTest -> CustomerTestDTO.build(customersTest, contTestContentsListId.get(customersTest.getIdTest()))).toList();

    }

    public CustomerTestDTO getCustomerTestById(final int idCustomerTest) throws Exception {
        final CustomerTest customerTestById = customerTestRepository.findById(idCustomerTest).get();
        final TestDTO testDTO = testService.getTestById(customerTestById.getIdTest());
        return CustomerTestDTO.build(customerTestById, testDTO);
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
