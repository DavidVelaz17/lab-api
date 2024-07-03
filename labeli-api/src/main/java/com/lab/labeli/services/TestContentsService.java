package com.lab.labeli.services;

import com.lab.labeli.dto.ContentsDTO;
import com.lab.labeli.dto.ReferencesDTO;
import com.lab.labeli.dto.TestContentsDTO;
import com.lab.labeli.dto.TestDTO;
import com.lab.labeli.entity.Contents;
import com.lab.labeli.entity.References;
import com.lab.labeli.entity.Test;
import com.lab.labeli.entity.TestContents;
import com.lab.labeli.form.TestContentsForm;
import com.lab.labeli.repository.ContentRepository;
import com.lab.labeli.repository.ReferencesRepository;
import com.lab.labeli.repository.TestContentsRepository;
import com.lab.labeli.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class TestContentsService {
    private final TestContentsRepository testContentsRepository;
    private final ContentService contentService;
    private final ReferencesRepository referencesRepository;
    private final ContentRepository contentRepository;

    private String notFound;


    private Map<Integer, ContentsDTO> getContentsIdsMap(final List<Integer> contentsId) {
        return contentService.getIdListByContents(contentsId);
    }

    public List <TestContentsDTO> getAllTestContents(){
        final List<TestContents> getAllContentList= testContentsRepository.findAll();
        final Map<Integer, ContentsDTO> contTestContentsListId = getContentsIdsMap(getAllContentList.stream().map(TestContents::getContentId).toList());
        return getAllContentList.stream().map(resultAndContentResults -> TestContentsDTO.build(resultAndContentResults, contTestContentsListId.get(resultAndContentResults.getIdTestContents()))).toList();
    }

    //Esta es la misma funcion que se usa en contentsService XD
    public ContentsDTO getContentsById(final int idContents) throws Exception {
        final Contents contents = contentRepository.findById(idContents).orElseThrow(() -> new Exception("Content not found"));
        final List<References> references = referencesRepository.findAllByContentId(idContents);
        final List<ReferencesDTO> referencesDTOList = references.stream()
                .map(ReferencesDTO::build)
                .collect(Collectors.toList());

        return ContentsDTO.build(contents, referencesDTOList);
    }


    public List<TestContentsDTO> getTestContentsByIdTest(final int idTest) throws Exception {
        // Obtener todos los TestContents por idTest
        final List<TestContents> getAllIdContentsId = testContentsRepository.findAllByTestsId(idTest);

        // Mapa para almacenar los ContentsDTO por contentId
        final Map<Integer, ContentsDTO> contentsMap = new HashMap<>();

        // Para cada TestContents, obtener su ContentsDTO correspondiente usando getContentsById
        for (TestContents testContent : getAllIdContentsId) {
            int contentId = testContent.getContentId();
            // Si aún no hemos cargado el ContentsDTO para este contentId, lo cargamos
            if (!contentsMap.containsKey(contentId)) {
                contentsMap.put(contentId, getContentsById(contentId));
            }
        }

        // Convertir cada TestContents a TestContentsDTO usando el ContentsDTO correspondiente
        return getAllIdContentsId.stream()
                .map(testContent -> TestContentsDTO.build(testContent, contentsMap.get(testContent.getContentId())))
                .collect(Collectors.toList());
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
