package com.project.timetablemgmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.dto.PeriodDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.service.PeriodService;
import com.project.timetablemgmt.validator.PeriodValidator;

@RestController
@RequestMapping("/api/period")
public class PeriodController {
    
    @Autowired
    private PeriodService service;

    @Autowired
    private PeriodValidator validator;

    @GetMapping
    public ResponseEntity<List<PeriodDTO>> getAll() {
        List<PeriodDTO> periods = service.getAll();
        return new ResponseEntity<>(periods, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodDTO> getById(@PathVariable Short id) {
        Optional<PeriodDTO> period = service.getById(id);
        return period.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<PeriodDTO> create(@RequestBody PeriodDTO period) throws AbstractException {
        validator.validate(period);
        
        PeriodDTO createdPeriod = service.create(period);
        return new ResponseEntity<>(createdPeriod, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PeriodDTO> update(@PathVariable Short id, @RequestBody PeriodDTO period) throws AbstractException {
        validator.validate(period);

        PeriodDTO updatedPeriod = service.update(id, period);
        return new ResponseEntity<>(updatedPeriod, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PeriodDTO> delete(@PathVariable Short id) {
        PeriodDTO deletedPeriod = service.delete(id);
        return new ResponseEntity<>(deletedPeriod, HttpStatus.OK);
    }
}
