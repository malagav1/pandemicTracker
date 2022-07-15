package com.domain.pandemictracker.converter;

import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.model.Disease;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DiseaseToEntityConverter implements Converter<Disease, DiseaseDto> {

    private final SymptomToEntityConverter symptomToEntityConverter;

    @Override
    public DiseaseDto convert(Disease source) {
        return DiseaseDto.builder()
            .name(source.getName())
            .isPandemic(source.isPandemic())
            .symptoms(source.getSymptoms().stream().map(s -> symptomToEntityConverter.convert(s)).collect(Collectors.toSet()))
            .build();
    }
}
