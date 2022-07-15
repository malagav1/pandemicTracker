package com.domain.pandemictracker.repository;

import com.domain.pandemictracker.model.Disease;
import org.springframework.data.repository.CrudRepository;

public interface DiseaseRepository extends CrudRepository<Disease, Long> {

}
