package com.lab.labeli.services;

import com.lab.labeli.dto.ContentsDTO;
import com.lab.labeli.dto.ContentsResultsDTO;
import com.lab.labeli.dto.ReferencesDTO;
import com.lab.labeli.dto.ResultDTO;
import com.lab.labeli.entity.Contents;
import com.lab.labeli.entity.ContentsResults;
import com.lab.labeli.entity.References;
import com.lab.labeli.entity.Result;
import com.lab.labeli.form.ContentsResultsForm;
import com.lab.labeli.repository.ContentRepository;
import com.lab.labeli.repository.ContentsResultsRepository;
import com.lab.labeli.repository.ReferencesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class ContentsResultsService {

    private final ContentsResultsRepository contentsResultsRepository;
    private final ContentService contentService;
    private final ReferencesRepository referencesRepository;
    private final ContentRepository contentRepository;



    @Value("${not.found}")
    private String notFound;

    public List<ContentsResultsDTO> getAllContentsResult() {
        final List<ContentsResults> getAll = contentsResultsRepository.findAll();
        return getAll.stream().map(ContentsResultsDTO::build).toList();
    }


    public ContentsResultsDTO getContentsResultsById(final int idContentsResult) throws Exception {
        validateIfContentsResultsExists(idContentsResult);
        final ContentsResults contentsResults = contentsResultsRepository.findById(idContentsResult).get();
        return ContentsResultsDTO.build(contentsResults);
    }

    private Map<Integer, ContentsDTO> getContentsIdsMap(final List<Integer> contentsId) {
        return contentService.getIdListByContents(contentsId);
    }

    /*
    public List<ContentsResultsDTO> getContentsResultsByResultId(final int resultId) throws Exception {
        final List<ContentsResults> listByResultId = contentsResultsRepository.findAllByResultId(resultId);
        final Map<Integer, ContentsDTO> contentsList = getContentsIdsMap(listByResultId.stream().map(ContentsResults::getContentId).toList());
        return listByResultId.stream().map(contentsBody -> ContentsResultsDTO.build(contentsBody, contentsList.get(contentsBody.getContentId()))).toList();
    }

     */

    //Esta es la misma funcion que se usa en contentsService XD
    public ContentsDTO getContentsById(final int idContents) throws Exception {
        final Contents contents = contentRepository.findById(idContents).orElseThrow(() -> new Exception("Content not found"));
        final List<References> references = referencesRepository.findAllByContentId(idContents);
        final List<ReferencesDTO> referencesDTOList = references.stream()
                .map(ReferencesDTO::build)
                .collect(Collectors.toList());

        return ContentsDTO.build(contents, referencesDTOList);
    }


    public List<ContentsResultsDTO> getContentsResultsByResultId(final int resultId) throws Exception {
        final List<ContentsResults> listByResultId = contentsResultsRepository.findAllByResultId(resultId);

        // Map para almacenar los ContentsDTO por idContents
        final Map<Integer, ContentsDTO> contentsMap = new HashMap<>();

        // Para cada ContentsResults, obtenemos su ContentsDTO correspondiente usando getContentsById
        for (ContentsResults contentsResult : listByResultId) {
            int contentId = contentsResult.getContentId();
            // Si no hemos cargado aún el ContentsDTO para este contentId, lo cargamos
            if (!contentsMap.containsKey(contentId)) {
                contentsMap.put(contentId, getContentsById(contentId));
            }
        }

        // Convertimos cada ContentsResults a ContentsResultsDTO usando el ContentsDTO correspondiente
        return listByResultId.stream()
                .map(contentsResult -> ContentsResultsDTO.build(contentsResult, contentsMap.get(contentsResult.getContentId())))
                .collect(Collectors.toList());
    }



    public Map<Integer, ContentsResultsDTO> getIdListByContentResults(final List<Integer> idContentsResult) {
        final List<ContentsResults> idList = contentsResultsRepository.findAllById(idContentsResult);
        return idLIstByContentResultsDTO(idList);
    }

    private Map<Integer, ContentsResultsDTO> idLIstByContentResultsDTO(final List<ContentsResults> contentsResultsInfo) {
        final List<ContentsResultsDTO> ContentsResultsDTOS =
                contentsResultsInfo.stream().map(ContentsResultsDTO::build).toList();
        return ContentsResultsDTOS
                .stream()
                .collect(Collectors.toMap(ContentsResultsDTO::getResultId, Function.identity()));
    }


    public void deleteContentsResults(final int idContentsResults) throws Exception {
        validateIfContentsResultsExists(idContentsResults);
        contentsResultsRepository.deleteById(idContentsResults);
    }

    public ContentsResultsDTO createContentsResults(final ContentsResultsForm form) {
        final ContentsResults contentsResults = new ContentsResults(form);
        contentsResultsRepository.save(contentsResults);
        return ContentsResultsDTO.build(contentsResults);
    }

    public ContentsResultsDTO updateContentsResults(final ContentsResultsForm form, final int idContentsResults) throws Exception {
        validateIfContentsResultsExists(idContentsResults);
        final ContentsResults contentsResults = contentsResultsRepository.findById(idContentsResults).get();
        contentsResults.updateContentsResults(form);
        contentsResultsRepository.save(contentsResults);
        return ContentsResultsDTO.build(contentsResults);

    }

    private void validateIfContentsResultsExists(final int idContentsResults) throws Exception {
        if (!contentsResultsRepository.existsById(idContentsResults)) {
            throw new Exception(notFound);
        }
    }
}
