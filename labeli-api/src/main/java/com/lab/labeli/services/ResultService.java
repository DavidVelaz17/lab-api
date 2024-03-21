package com.lab.labeli.services;

import com.lab.labeli.dto.ResultDTO;
import com.lab.labeli.entity.Result;
import com.lab.labeli.form.ResultForm;
import com.lab.labeli.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")
public class ResultService {

    private final ResultRepository resultRepository;

    @Value("${not.found}")
    private String notFound;

    public List<ResultDTO> getAllResult() {
        final List<Result> getAll = resultRepository.findAll();
        return getAll.stream().map(ResultDTO::build).toList();
    }

    public ResultDTO getResultById(final int idResult) throws Exception {
        validateIfResultExists(idResult);
        final Result result = resultRepository.findById(idResult).get();
        return ResultDTO.build(result);
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
}
