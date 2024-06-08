package com.lab.labeli.services;

import com.lab.labeli.dto.ContentsDTO;
import com.lab.labeli.entity.Contents;
import com.lab.labeli.form.ContentsForm;
import com.lab.labeli.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")

public class ContentService {
    private final ContentRepository contentRepository;

    @Value("${not.found}")
    private String notFound;

    public List<ContentsDTO> getAllContents(){
        final List<Contents> getAll = contentRepository.findAll();
        return getAll.stream().map(ContentsDTO::build).toList();
    }

    public ContentsDTO getContentsById(final int idContents) throws Exception{
        validateIfContentsExists(idContents);
        final Contents contents = contentRepository.findById(idContents).get();
        return ContentsDTO.build(contents);
    }

    public void deleteContents(final int idContent) throws Exception{
        validateIfContentsExists(idContent);
        contentRepository.deleteById(idContent);
    }

    public ContentsDTO createContents(final ContentsForm form){
        final Contents contents = new Contents(form);
        contentRepository.save(contents);
        return ContentsDTO.build(contents);
    }

    public ContentsDTO updateContents(final ContentsForm form, final int idContents) throws Exception{
        validateIfContentsExists(idContents);
        final Contents contents = contentRepository.findById(idContents).get();
        contents.updateContents(form);
        contentRepository.save(contents);
        return ContentsDTO.build(contents);
    }
    private void validateIfContentsExists(final int idContents) throws Exception{
        if(!contentRepository.existsById(idContents)){
            throw new Exception(notFound);
        }
    }

    public Map<Integer, ContentsDTO> getIdListByContents(final List<Integer> idContentsService){
        final List<Contents> contentsList = contentRepository.findAllById(idContentsService);
        return contentsDTOs(contentsList);
    }

    private Map<Integer, ContentsDTO> contentsDTOs(final List<Contents> contentsBody){
        final List<ContentsDTO> contentsDtoInfo = contentsBody.stream().map(ContentsDTO::build).toList();
        return contentsDtoInfo.stream().collect(Collectors.toMap(ContentsDTO::getContentId, Function.identity()));
    }

}
