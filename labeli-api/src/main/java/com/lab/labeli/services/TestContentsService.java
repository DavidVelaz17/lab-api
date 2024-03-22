package com.lab.labeli.services;

import com.lab.labeli.dto.TestContentsDTO;
import com.lab.labeli.entity.TestContents;
import com.lab.labeli.form.TestContentsForm;
import com.lab.labeli.repository.TestContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class TestContentsService {
    private final TestContentsRepository testContentsRepository;
    @Value("${not.found}")
    private String notFound;

public List <TestContentsDTO> getAllTestContents(){
    final List<TestContents> getAll= testContentsRepository.findAll();
    return getAll.stream().map(TestContentsDTO::build).toList();
}
public TestContentsDTO getTestContentsById(final int idTest) throws Exception {
    validateIfTestContentsExists(idTest);
    final TestContents testContents = testContentsRepository.findById(idTest).get();
    return TestContentsDTO.build(testContents);
}

public void deleteTestContentsCustomer(final int idTest) throws Exception {
    validateIfTestContentsExists(idTest);
    testContentsRepository.deleteById(idTest);
}
public TestContentsDTO createTestContents(final TestContentsForm form) {
    final TestContents testContent = new TestContents(form);
    testContentsRepository.save(testContent);
    return TestContentsDTO.build(testContent);
}

public TestContentsDTO updateCustomer(final TestContentsForm form, final int idTest) throws Exception {
    validateIfTestContentsExists(idTest);
    final TestContents testContents = testContentsRepository.findById(idTest).get();
    testContents.updateTestContentsFunction(form);
    testContentsRepository.save(testContents);
    return TestContentsDTO.build(testContents);
}

private void validateIfTestContentsExists(final int idTest) throws Exception{
    if(!testContentsRepository.existsById(idTest)){
            throw new Exception(notFound);
        }
    }
}
