package com.domain.pandemictracker.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.model.Disease;
import com.domain.pandemictracker.model.Symptom;
import com.domain.pandemictracker.repository.DiseaseRepository;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

@ExtendWith(MockitoExtension.class)
public class DiseaseServiceTest {

    private static final String DISEASE_NAME = "Dummy Disease Name";
    private static final String SYMPTOM_1_NAME = "first symptom";

    @Mock
    private DiseaseRepository diseaseRepository;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private DiseaseServiceImpl target;

    @Test
    void whenFindAllDiseases_thenCheckResponse() {
        Symptom symptom = buildSymptom(SYMPTOM_1_NAME);
        Disease disease = buildDisease(Stream.of(symptom).collect(Collectors.toSet()));

        SymptomDto expectedSymptomDto = buildSymptomDto(SYMPTOM_1_NAME);
        DiseaseDto expectedDiseaseDto = buildDiseaseDto(Stream.of(expectedSymptomDto).collect(Collectors.toSet()));

        when(diseaseRepository.findAll()).thenReturn(Arrays.asList(disease));
        when(conversionService.convert(disease, DiseaseDto.class)).thenReturn(expectedDiseaseDto);

        Set<DiseaseDto> diseaseDtos = target.findAll();

        assertFalse(diseaseDtos.isEmpty());
        assertTrue(diseaseDtos.equals(Stream.of(expectedDiseaseDto).collect(Collectors.toSet())));



    }

    private SymptomDto buildSymptomDto(String symptomName) {
        return SymptomDto.builder().name(symptomName).build();
    }

    private DiseaseDto buildDiseaseDto(Set<SymptomDto> symptomDtos) {
        return DiseaseDto.builder()
            .name(DISEASE_NAME)
            .symptoms(symptomDtos)
            .build();
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
