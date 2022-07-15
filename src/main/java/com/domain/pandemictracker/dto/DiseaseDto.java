package com.domain.pandemictracker.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseDto {
    private String name;
    private boolean isPandemic;
    private Set<SymptomDto> symptoms;
}
