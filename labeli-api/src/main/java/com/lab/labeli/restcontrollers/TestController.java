package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.TestDTO;
import com.lab.labeli.form.TestForm;
import com.lab.labeli.services.TestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/lab/test")
public class TestController {
    private final TestService testService;

    @GetMapping(path = "")
    public ResponseEntity<List<TestDTO>> getALlTesteList() {
        final List<TestDTO> testList = testService.getAllTestList();
        return ResponseEntity.ok().body(testList);
    }

    @GetMapping(path = "/{testId}")
    public ResponseEntity<TestDTO> getTestById(@PathVariable("testId") final int testId) throws Exception {
        final TestDTO testById = testService.getTestById(testId);
        return ResponseEntity.ok().body(testById);
    }

    @PostMapping(path = "")
    public ResponseEntity<TestDTO> saveNewTest(@RequestBody @Valid final TestForm form) {
        final TestDTO saveTest = testService.createNewTest(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveTest);
    }

    @DeleteMapping(path = "/{testId}")
    public ResponseEntity<Void> deleteTestById(@PathVariable("testId") final int testId) throws Exception {
        testService.deleteTestById(testId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{testId}")
    public ResponseEntity<TestDTO> updateTest(@RequestBody @Valid final TestForm form, @PathVariable("testId") final int testId) throws Exception {
        final TestDTO updateTestById = testService.updateTest(form, testId);
        return ResponseEntity.ok().body(updateTestById);
    }

}
