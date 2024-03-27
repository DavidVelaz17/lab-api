package com.lab.labeli.services;
import com.lab.labeli.dto.ContentsResultsDTO;
import com.lab.labeli.entity.ContentsResults;
import com.lab.labeli.form.ContentsResultsForm;
import com.lab.labeli.repository.ContentsResultsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class ContentsResultsService {

    private final ContentsResultsRepository contentsResultsRepository;
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

    private void validateIfContentsResultsExists(final int idContentsResults) throws Exception{
        if(!contentsResultsRepository.existsById(idContentsResults)){
            throw new Exception(notFound);
        }
    }
}
