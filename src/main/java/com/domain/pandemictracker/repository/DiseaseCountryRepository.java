package com.domain.pandemictracker.repository;

import com.domain.pandemictracker.model.DiseaseCountry;
import com.domain.pandemictracker.model.DiseaseCountryId;
import org.springframework.data.repository.CrudRepository;

public interface DiseaseCountryRepository extends CrudRepository<DiseaseCountry, DiseaseCountryId> {

}
