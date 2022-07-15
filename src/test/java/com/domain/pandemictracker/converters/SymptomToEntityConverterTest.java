package com.domain.pandemictracker.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.domain.pandemictracker.converter.SymptomToEntityConverter;
import com.domain.pandemictracker.dto.SymptomDto;
import com.domain.pandemictracker.model.Symptom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SymptomToEntityConverterTest {

    private static final String SYMPTOM_NAME = "Dummy Symptom";

    private SymptomToEntityConverter target;

    @BeforeEach
    void init(){
        target = new SymptomToEntityConverter();
    }

    private Symptom buildSymptomEntity(){
        return Symptom.builder()
            .name(SYMPTOM_NAME)
            .build();
    }

    @Test
    void whenConvertSymptomToEntity_thenCheckSymptomName(){
        SymptomDto dto = target.convert(buildSymptomEntity());
        assertEquals(SYMPTOM_NAME, dto.getName());
    }

}
