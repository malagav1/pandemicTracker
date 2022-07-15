package com.domain.pandemictracker.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = "country")
@Table(name="Disease_Country")
public class DiseaseCountry {
    @EmbeddedId
    private DiseaseCountryId id = new DiseaseCountryId();

    @ManyToOne
    @MapsId("diseaseId")
    private Disease disease;

    @ManyToOne
    @MapsId("countryId")
    private Country country;

    private boolean criticalThresholdReached;
}
