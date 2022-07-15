package com.domain.pandemictracker.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseCountryId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long diseaseId;
    private Long countryId;
}
