package com.lab.labeli.restcontrollers;

import com.lab.labeli.dto.ContentsDTO;
import com.lab.labeli.form.ContentsForm;
import com.lab.labeli.services.ContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/lab/contents")
@RequiredArgsConstructor
public class ContentsController {
    private final ContentService contentService;

    @GetMapping("")
    public  ResponseEntity<List<ContentsDTO>> getAllContents(){
        final List<ContentsDTO> contentsDTOList = contentService.getAllContents();
        return ResponseEntity.ok().body(contentsDTOList);
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ContentsDTO> getContentById(@PathVariable("contentId") final int contentId) throws Exception{
        final ContentsDTO ContentsInfo = contentService.getContentsById(contentId);
        return ResponseEntity.ok().body(ContentsInfo);
    }

    @PostMapping("")
    public ResponseEntity<ContentsDTO> saveContents(@RequestBody @Valid final ContentsForm form){
        final ContentsDTO saveContentInfo = contentService.createContents(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveContentInfo);
    }

    @DeleteMapping("/{contentId}")
        public ResponseEntity<Void> deleteContent(@PathVariable("contentId") final int contentId)throws Exception{
            contentService.deleteContents(contentId);
            return ResponseEntity.ok().build();
        }
    @PatchMapping("/{contentId}")
    public ResponseEntity<ContentsDTO> updateContent(@RequestBody @Valid final ContentsForm contentInfo, @PathVariable ("contentId") final int contentId) throws Exception{
        final ContentsDTO updateContentInfo = contentService.updateContents(contentInfo, contentId);
        return ResponseEntity.ok().body(updateContentInfo);
    }

}
