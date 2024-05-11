package com.lab.labeli.services;

import com.lab.labeli.dto.ContentsDTO;
import com.lab.labeli.dto.TestContentsDTO;
import com.lab.labeli.dto.TestDTO;
import com.lab.labeli.entity.Contents;
import com.lab.labeli.entity.Test;
import com.lab.labeli.entity.TestContents;
import com.lab.labeli.form.TestContentsForm;
import com.lab.labeli.repository.TestContentsRepository;
import com.lab.labeli.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class TestContentsService {
    private final TestContentsRepository testContentsRepository;
    private final ContentService contentService;
    private String notFound;


    private Map<Integer, ContentsDTO> getContentsIdsMap(final List<Integer> contentsId) {
        return contentService.getIdListByContents(contentsId);
    }

    public List <TestContentsDTO> getAllTestContents(){
        final List<TestContents> getAllContentList= testContentsRepository.findAll();
        final Map<Integer, ContentsDTO> contTestContentsListId = getContentsIdsMap(getAllContentList.stream().map(TestContents::getContentId).toList());
        return getAllContentList.stream().map(resultAndContentResults -> TestContentsDTO.build(resultAndContentResults, contTestContentsListId.get(resultAndContentResults.getIdTestContents()))).toList();
    }

    public List<TestContentsDTO> getTestContentsByIdTest(final int idTest) throws Exception{
        final List<TestContents> getAllIdContentsId = testContentsRepository.findAllByTestsId(idTest);
        final Map<Integer, ContentsDTO> contentsListId = getContentsIdsMap(getAllIdContentsId.stream().map(TestContents::getContentId).toList());
        return getAllIdContentsId.stream().map(contentsBody -> TestContentsDTO.build(contentsBody,contentsListId.get(contentsBody.getContentId()))).toList();
    }


    public TestContentsDTO getTestContentsById(final int idTest) throws Exception {
        validateIfTestContentsExists(idTest);
        final TestContents testContents = testContentsRepository.findById(idTest).get();
        return TestContentsDTO.build(testContents);
    }

    public void deleteTestContents(final int idTest) throws Exception {
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

    private void validateIfTestContentsExists(final int idTest) throws Exception {
        if (!testContentsRepository.existsById(idTest)) {
            throw new Exception(notFound);
        }
    }
}
