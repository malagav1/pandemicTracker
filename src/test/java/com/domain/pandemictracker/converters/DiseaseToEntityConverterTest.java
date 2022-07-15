package com.domain.pandemictracker.converters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.domain.pandemictracker.converter.DiseaseToEntityConverter;
import com.domain.pandemictracker.converter.SymptomToEntityConverter;
import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.model.Disease;
import com.domain.pandemictracker.model.Symptom;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class DiseaseToEntityConverterTest {

    private static final String DISEASE_NAME = "Dummy Disease Name";
    private static final String SYMPTOM_1_NAME = "first symptom";
    private static final String SYMPTOM_2_NAME = "second symptom";

    @Mock
    private SymptomToEntityConverter symptomToEntityConverter;

    @InjectMocks
    private DiseaseToEntityConverter target;

    @Test
    void whenConvertingDisease_thenCheckSymptomsNameAndDiseaseName() {

        Symptom symptom1 = buildSymptom(SYMPTOM_1_NAME);
        Symptom symptom2 = buildSymptom(SYMPTOM_2_NAME);

        Disease disease = buildDisease(Stream.of(symptom1, symptom2).collect(Collectors.toSet()));

        SymptomDto expectedSymptom1 = buildSymptomDto(SYMPTOM_1_NAME);
        SymptomDto expectedSymptom2 = buildSymptomDto(SYMPTOM_2_NAME);

        when(symptomToEntityConverter.convert(symptom1)).thenReturn(expectedSymptom1);
        when(symptomToEntityConverter.convert(symptom2)).thenReturn(expectedSymptom2);

        DiseaseDto dto = target.convert(disease);
        assertFalse(dto.getSymptoms().isEmpty());
        assertTrue(dto.getSymptoms().contains(expectedSymptom1));
        assertTrue(dto.getSymptoms().contains(expectedSymptom2));
        assertTrue(dto.getName().equals(DISEASE_NAME));
    }

    private SymptomDto buildSymptomDto(String symptomName) {
        return SymptomDto.builder().name(symptomName).build();
    }

    private Symptom buildSymptom(String name) {
        return Symptom.builder()
            .name(name)
            .build();
    }

    private Disease buildDisease(Set<Symptom> symptoms) {
        return Disease.builder()
            .id(1)
            .name(DISEASE_NAME)
            .isPandemic(true)
            .symptoms(symptoms)
            .build();
    }
}
