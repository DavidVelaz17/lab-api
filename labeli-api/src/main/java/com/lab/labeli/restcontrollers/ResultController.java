package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.ResultDTO;
import com.lab.labeli.form.ResultForm;
import com.lab.labeli.services.ResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/lab/result")
public class ResultController {
    private final ResultService resultService;

    @GetMapping
    public ResponseEntity<List<ResultDTO>> getAllResults(){
        final List<ResultDTO> resultDTOS = resultService.getAllResult();
        return ResponseEntity.ok().body(resultDTOS);
    }

    @GetMapping("/{resultId}")
    public ResponseEntity<ResultDTO> getResultById(@PathVariable("resultId") final int resultId) throws Exception {
        final ResultDTO resultDTO = resultService.getResultById(resultId);
        return ResponseEntity.ok().body(resultDTO);
    }

    @PostMapping
    public ResponseEntity<ResultDTO> saveResult(@RequestBody @Valid final ResultForm form){
        final ResultDTO resultDTO = resultService.createResult(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultDTO);
    }

    @DeleteMapping("/{resultId}")
    public ResponseEntity<ResultDTO> deleteResult(@PathVariable("resultId") final int resultId) throws Exception {
        resultService.deleteResult(resultId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{resultId}")
    public ResponseEntity<ResultDTO> updateResult(@RequestBody @Valid final ResultForm form, @PathVariable("resultId") final int resultId) throws Exception {
        final ResultDTO resultDTO = resultService.updateResult(form,resultId);
        return ResponseEntity.ok().body(resultDTO);
    }

}
