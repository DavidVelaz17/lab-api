package com.lab.labeli.services;

import com.lab.labeli.dto.TestDTO;
import com.lab.labeli.entity.Test;
import com.lab.labeli.form.TestForm;
import com.lab.labeli.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class TestService {
    private final TestRepository testRepository;

    @Value("${not.found}")
    private String notFound;

    private void validateIfTestExists(final int idTest) throws Exception {
        if (!testRepository.existsById(idTest)) {
            throw new Exception(notFound);
        }
    }

    public List<TestDTO> getAllTestList() {
        final List<Test> getAll = testRepository.findAll();
        return getAll.stream().map(TestDTO::build).toList();
    }

    public TestDTO getTestById(final int idTest) throws Exception {
        validateIfTestExists(idTest);
        final Test getTest = testRepository.findById(idTest).get();
        return TestDTO.build(getTest);
    }

    public void deleteTestById(final int idTest) throws Exception {
        validateIfTestExists(idTest);
        testRepository.deleteById(idTest);
    }

    public TestDTO createNewTest(final TestForm form) {
        final Test createTest = new Test(form);
        testRepository.save(createTest);
        return TestDTO.build(createTest);
    }

    public TestDTO updateTest(final TestForm form, final int idTest) throws Exception {
        validateIfTestExists(idTest);
        final Test updateTestById = testRepository.findById(idTest).get();
        updateTestById.updateTestFunction(form);
        testRepository.save(updateTestById);
        return TestDTO.build(updateTestById);

    }

    public Map<Integer, TestDTO> getTestsByIds(final List<Integer> testsIds) {
        final List<Test> testDTOS = testRepository.findAllById(testsIds);
        return testDTOs(testDTOS);
    }

    private Map<Integer, TestDTO> testDTOs(final List<Test> tests){
        final List<TestDTO> testDTOS=tests.stream().map(TestDTO::build).toList();
        return testDTOS.stream().collect(Collectors.toMap(TestDTO::getIdTest, Function.identity()));
    }
}