package com.lab.labeli.restcontrollers;
import com.lab.labeli.dto.ContentsResultsDTO;
import com.lab.labeli.form.ContentsResultsForm;
import com.lab.labeli.services.ContentsResultsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/lab/contentsresults")
@RequiredArgsConstructor

public class ContentsResultsController {
    private final ContentsResultsService contentsResultsService;

    @GetMapping("")
    public ResponseEntity<List<ContentsResultsDTO>> getAllContentsResults(){
        final List<ContentsResultsDTO> contentsResultsDTOList = contentsResultsService.getAllContentsResult();
        return ResponseEntity.ok().body(contentsResultsDTOList);
    }

    @GetMapping("/{contentsResultsId}")
    public ResponseEntity<ContentsResultsDTO> getContentsResultsById(@PathVariable("contentsResultsId") final int contentsResultsId) throws Exception{
        final ContentsResultsDTO contentsResultsDTOInfo = contentsResultsService.getContentsResultsById(contentsResultsId);
        return ResponseEntity.ok().body(contentsResultsDTOInfo);
    }

    @PostMapping("")
    public ResponseEntity<ContentsResultsDTO> saveContentsResults(@RequestBody @Valid final ContentsResultsForm form){
        final ContentsResultsDTO saveContentsResultsInfo = contentsResultsService.createContentsResults(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveContentsResultsInfo);
    }

    @DeleteMapping("/{contentsResultsId}")
    public ResponseEntity<Void> deleteContentsController(@PathVariable("contentsResultsId") final int contentsResultsId)throws Exception{
        contentsResultsService.deleteContentsResults(contentsResultsId);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{contentsResultsId}")
    public ResponseEntity<ContentsResultsDTO> updateContentsResults(@RequestBody @Valid final ContentsResultsForm contentsResultsFormInfo, @PathVariable("contentsResultsId") final int contentsResultsId) throws Exception{
        final ContentsResultsDTO updateContentsResultsInfo = contentsResultsService.updateContentsResults(contentsResultsFormInfo,contentsResultsId);
        return ResponseEntity.ok().body(updateContentsResultsInfo);
    }


}
