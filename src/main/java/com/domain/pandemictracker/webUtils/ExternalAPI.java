package com.domain.pandemictracker.webUtils;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class ExternalAPI {
    public Boolean getUpdatedCountryThreshold(){
        Random rd = new Random();
        return rd.nextBoolean();
    }
}
