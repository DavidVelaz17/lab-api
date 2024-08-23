package com.lab.labeli.services;

import com.lab.labeli.dto.ContentsDTO;
import com.lab.labeli.dto.ContentsResultsDTO;
import com.lab.labeli.dto.ResultDTO;
import com.lab.labeli.entity.ContentsResults;
import com.lab.labeli.entity.Result;
import com.lab.labeli.form.ContentsResultsForm;
import com.lab.labeli.repository.ContentsResultsRepository;
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
public class ContentsResultsService {

    private final ContentsResultsRepository contentsResultsRepository;
    private final ContentService contentService;

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

    public List<ContentsResultsDTO> getContentsResultsByResultId(final int resultId) throws Exception {
        final List<ContentsResults> listByResultId = contentsResultsRepository.findAllByResultId(resultId);
        final Map<Integer, ContentsDTO> contentsList = getContentsIdsMap(listByResultId.stream().map(ContentsResults::getContentId).toList());
        return listByResultId.stream().map(contentsBody -> ContentsResultsDTO.build(contentsBody, contentsList.get(contentsBody.getContentId()))).toList();
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
