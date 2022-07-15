package com.domain.pandemictracker.service;


import com.domain.pandemictracker.dto.DiseaseDto;
import java.util.Set;

public interface DiseaseService  {
    Set<DiseaseDto> findAll();
}
