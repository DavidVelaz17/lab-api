package com.lab.labeli.services;

import com.lab.labeli.dto.ReferencesDTO;
import com.lab.labeli.entity.References;
import com.lab.labeli.repository.ReferencesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferencesService {
    private final ReferencesRepository referencesRepository;

    public List<ReferencesDTO> getReferencesByContentsId(final int idContent){
        final List<References> references = referencesRepository.findAllByContentId(idContent);
        return references.stream().map(ReferencesDTO::build).toList();
    }
}
