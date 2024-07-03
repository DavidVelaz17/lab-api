package com.lab.labeli.services;

import com.lab.labeli.dto.ContentsDTO;
import com.lab.labeli.dto.ReferencesDTO;
import com.lab.labeli.entity.Contents;
import com.lab.labeli.entity.References;
import com.lab.labeli.form.ContentsForm;
import com.lab.labeli.repository.ContentRepository;
import com.lab.labeli.repository.ReferencesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ValidationsMessages.properties")

public class ContentService {
    private final ContentRepository contentRepository;
    private final ReferencesRepository referencesRepository;

    @Value("${not.found}")
    private String notFound;

    /*
    public List<ContentsDTO> getAllContents() {
        final List<Contents> getAll = contentRepository.findAll();
        return getAll.stream().map(ContentsDTO::build).toList();
    }

     */
    public List<ContentsDTO> getAllContents() {
        // Obtener todos los contenidos
        List<Contents> contentsList = contentRepository.findAll();

        // Para cada contenido, obtener sus referencias y construir el DTO correspondiente
        return contentsList.stream().map(content -> {
            List<References> references = referencesRepository.findAllByContentId(content.getContentId());
            List<ReferencesDTO> referencesDTOList = references.stream()
                    .map(ReferencesDTO::build)
                    .collect(Collectors.toList());

            return ContentsDTO.build(content, referencesDTOList);
        }).collect(Collectors.toList());
    }

    public ContentsDTO getContentsById(final int idContents) throws Exception {
        final Contents contents = contentRepository.findById(idContents).orElseThrow(() -> new Exception("Content not found"));
        final List<References> references = referencesRepository.findAllByContentId(idContents);
        final List<ReferencesDTO> referencesDTOList = references.stream()
                .map(ReferencesDTO::build)
                .collect(Collectors.toList());

        return ContentsDTO.build(contents, referencesDTOList);
    }

    public void deleteContents(final int idContent) throws Exception {
        validateIfContentsExists(idContent);
        contentRepository.deleteById(idContent);
    }

    public ContentsDTO createContents(final ContentsForm form) {
        final Contents contents = new Contents(form);
        contentRepository.save(contents);
        return ContentsDTO.build(contents);
    }

    public ContentsDTO updateContents(final ContentsForm form, final int idContents) throws Exception {
        validateIfContentsExists(idContents);
        final Contents contents = contentRepository.findById(idContents).get();
        contents.updateContents(form);
        contentRepository.save(contents);
        return ContentsDTO.build(contents);
    }

    private void validateIfContentsExists(final int idContents) throws Exception {
        if (!contentRepository.existsById(idContents)) {
            throw new Exception(notFound);
        }
    }

    public Map<Integer, ContentsDTO> getIdListByContents(final List<Integer> idContentsService) {
        final List<Contents> contentsList = contentRepository.findAllById(idContentsService);
        return contentsDTOs(contentsList);
    }

    private Map<Integer, ContentsDTO> contentsDTOs(final List<Contents> contentsBody) {
        final List<ContentsDTO> contentsDtoInfo = contentsBody.stream().map(ContentsDTO::build).toList();
        return contentsDtoInfo.stream().collect(Collectors.toMap(ContentsDTO::getContentId, Function.identity()));
    }

}
