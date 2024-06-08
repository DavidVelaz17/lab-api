package com.lab.labeli.restcontrollers;
import com.lab.labeli.dto.CustomerTestDTO;
import com.lab.labeli.dto.TestContentsDTO;
import com.lab.labeli.form.TestContentsForm;
import com.lab.labeli.services.TestContentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path = "/lab/testcontents")
@RequiredArgsConstructor
public class TestContentsController {
    private final TestContentsService testContentsService;

    @GetMapping("")
    public ResponseEntity<List <TestContentsDTO>> getAllTestContents(){
        final List<TestContentsDTO> testContentsList = testContentsService.getAllTestContents();
        return ResponseEntity.ok().body(testContentsList);
    }

    @GetMapping(path = "/test/{testId}")
    public ResponseEntity<List<TestContentsDTO>> getAllTestContentsByTestId(@PathVariable("testId") final int testId) throws Exception {
        final List<TestContentsDTO> testContentsInfo = testContentsService.getTestContentsByIdTest(testId);
        return ResponseEntity.ok().body(testContentsInfo);
    }

    @GetMapping("/{testContentId}")
    public ResponseEntity<TestContentsDTO> getTestContentsById(@PathVariable("testContentId") final int testContentId)throws Exception{
        final TestContentsDTO testContentsDTOInfo = testContentsService.getTestContentsById(testContentId);
        return ResponseEntity.ok().body(testContentsDTOInfo);
    }

    @PostMapping("")
    public ResponseEntity<TestContentsDTO> saveTestContents(@RequestBody @Valid final TestContentsForm form){
        final TestContentsDTO saveTestContentInfo = testContentsService.createTestContents(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveTestContentInfo);
    }

    @DeleteMapping("/{testContentId}")
    public ResponseEntity<Void> deleteTestContents(@PathVariable("testContentId") final int testContentId) throws Exception{
        testContentsService.deleteTestContents(testContentId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{testContentId}")
    public ResponseEntity<TestContentsDTO> updateTestContent(@RequestBody @Valid final TestContentsForm testContentInfo, @PathVariable("testContentId") final int testContentId) throws Exception{
        final TestContentsDTO updateTestContentInfo = testContentsService.updateCustomer(testContentInfo, testContentId);
        return ResponseEntity.ok().body(updateTestContentInfo);
    }
}
