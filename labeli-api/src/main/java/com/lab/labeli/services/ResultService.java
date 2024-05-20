package com.lab.labeli.services;

import com.lab.labeli.dto.ContentsResultsDTO;
import com.lab.labeli.dto.ResultDTO;
import com.lab.labeli.entity.ContentsResults;
import com.lab.labeli.entity.Result;
import com.lab.labeli.form.ResultForm;
import com.lab.labeli.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class ResultService {

    private final ResultRepository resultRepository;
    private final ContentsResultsService contentsResultsService;

    @Value("${not.found}")
    private String notFound;

    private Map<Integer, ContentsResultsDTO> getContentsResultsIdsMap(final List<Integer> contentsId) {
        return contentsResultsService.getIdListByContentResults(contentsId);
    }

    public List<ResultDTO> getAllResult() {
        final List<Result> resultsList = resultRepository.findAll();
        final Map<Integer, ContentsResultsDTO> contResultsListId = getContentsResultsIdsMap(resultsList.stream().map(Result::getIdResults).toList());
        return resultsList
                .stream()
                .map(resultAndContentResults -> ResultDTO.build(
                        resultAndContentResults, contResultsListId.get(resultAndContentResults.getIdResults())
                ))
                .toList();
    }

    public List<ResultDTO> getResultsByIdCustomer(final int idCustomer) throws Exception {
        final List<Result> getAllResultsByIdCustomer = resultRepository.findAllByIdCustomers(idCustomer);
        final Map<Integer, ContentsResultsDTO> contResultsListId = getContentsResultsIdsMap(getAllResultsByIdCustomer.stream().map(Result::getIdResults).toList());
        return getAllResultsByIdCustomer
                .stream()
                .map(resultAndContentResults -> ResultDTO.build(
                        resultAndContentResults, contResultsListId.get(resultAndContentResults.getIdResults())
                ))
                .toList();
    }

    public ResultDTO getResultById(final int idResult) throws Exception {
        validateIfResultExists(idResult);
        final Result resultBodyInfo = resultRepository.findById(idResult).get();
        final ContentsResultsDTO contentsResultsBodyInfo = contentsResultsService.getContentsResultsById(resultBodyInfo.getIdResults());
        return ResultDTO.build(resultBodyInfo, contentsResultsBodyInfo);
    }

    public void deleteResult(final int idResult) throws Exception {
        validateIfResultExists(idResult);
        resultRepository.deleteById(idResult);
    }

    public ResultDTO createResult(final ResultForm form) {
        final Result result = new Result(form);
        resultRepository.save(result);
        return ResultDTO.build(result);
    }

    public ResultDTO updateResult(final ResultForm form, final int idResult) throws Exception {
        validateIfResultExists(idResult);
        final Result result = resultRepository.findById(idResult).get();
        result.updateResult(form);
        resultRepository.save(result);
        return ResultDTO.build(result);

    }

    private void validateIfResultExists(final int idResult) throws Exception {
        if (!resultRepository.existsById(idResult)) {
            throw new Exception(notFound);
        }
    }

    public void deleteResultByIdTestAndIdCustomer(final int idTest, final int idCustomer) throws Exception {
        resultRepository.deleteByIdTestsAndIdCustomers(idTest, idCustomer);
    }

    public List<ResultDTO> getResultByIdTestsAndIdCustomers(final int idCustomer, final int idTest) throws Exception {
        final List<Result> getAllResultsByIdCustomerAndIdTest = resultRepository.findAllByIdTestsAndIdCustomers(idCustomer,idTest);
        final Map<Integer, ContentsResultsDTO> contResultsListId = getContentsResultsIdsMap(getAllResultsByIdCustomerAndIdTest.stream().map(Result::getIdResults).toList());
        return getAllResultsByIdCustomerAndIdTest
                .stream()
                .map(resultAndContentResults -> ResultDTO.build(
                        resultAndContentResults, contResultsListId.get(resultAndContentResults.getIdResults())
                ))
                .toList();
    }
}
