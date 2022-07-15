package com.domain.pandemictracker.service;

import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.model.Disease;
import com.domain.pandemictracker.repository.DiseaseRepository;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository diseaseRepository;
    private final ConversionService conversionService;

    @Override
    public Set<DiseaseDto> findAll() {
        Iterable<Disease> diseases = diseaseRepository.findAll();
        return StreamSupport.stream(diseases.spliterator(), false).map(d -> conversionService.convert(d, DiseaseDto.class))
            .collect(Collectors.toSet());
    }
}
