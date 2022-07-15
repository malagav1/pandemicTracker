package com.domain.pandemictracker.controller;

import static com.domain.pandemictracker.webUtils.UrlConstants.DISEASE_API_PATH;

import com.domain.pandemictracker.dto.DiseaseDto;
import com.domain.pandemictracker.service.DiseaseService;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class DiseaseController {

    private final DiseaseService diseaseService;

    @RequestMapping(value = DISEASE_API_PATH, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Set<DiseaseDto>> getAll(){
        return ResponseEntity.ok(diseaseService.findAll());
    }
}
