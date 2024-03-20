package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.TestDTO;
import com.lab.labeli.form.TestForm;
import com.lab.labeli.services.TestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/lab/test")
public class TestController {
    private final TestService testService;

    @GetMapping("")
    public ResponseEntity<List<TestDTO>> getAllTestList() {
        final List<TestDTO> testList = testService.getAllTestList();
        return ResponseEntity.ok().body(testList);
    }

    @GetMapping("/{testId}")
    public ResponseEntity<TestDTO> getTestById(@PathVariable("testId") final int testId) throws Exception {
        final TestDTO getTest = testService.getTestById(testId);
        return ResponseEntity.ok().body(getTest);
    }

    @PostMapping("")
    public ResponseEntity<TestDTO> saveNewTest(@RequestBody @Valid final TestForm form) {
        final TestDTO saveTest = testService.createNewTest(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveTest);
    }

    @DeleteMapping("/{testId}")
    public ResponseEntity<Void> deleteTest(@PathVariable("testId") final int testId) throws Exception {
        testService.deleteTestById(testId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{testId}")
    public ResponseEntity<TestDTO> updateTest(@RequestBody @Valid final TestForm testInfo, @PathVariable("testId") final int testId) throws Exception {
        final TestDTO updateTest = testService.updateTest(testInfo, testId);
        return ResponseEntity.ok().body(updateTest);
    }

}
