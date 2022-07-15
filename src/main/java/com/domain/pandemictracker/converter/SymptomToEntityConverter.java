package com.domain.pandemictracker.converter;

import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.model.Symptom;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SymptomToEntityConverter implements Converter<Symptom, SymptomDto> {

    @Override
    public SymptomDto convert(Symptom source) {
        return SymptomDto.builder()
            .name(source.getName())
            .build();
    }
}
