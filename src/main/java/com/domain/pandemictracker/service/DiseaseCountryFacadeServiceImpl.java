package com.domain.pandemictracker.service;

import com.domain.pandemictracker.model.DiseaseCountry;
import com.domain.pandemictracker.repository.DiseaseCountryRepository;
import com.domain.pandemictracker.webUtils.ExternalAPI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DiseaseCountryFacadeServiceImpl implements DiseaseCountryFacadeService{
    private final DiseaseCountryRepository diseaseCountryRepository;
    private final ExternalAPI externalAPI;

    @Override
    public void updateThresholdReachedFromOutside(){
        Iterable<DiseaseCountry> entities = diseaseCountryRepository.findAll();
        log.info("Number of entries: {}", diseaseCountryRepository.count());
        entities.forEach(entity -> entity.setCriticalThresholdReached(externalAPI.getUpdatedCountryThreshold())
        );
    }
}
