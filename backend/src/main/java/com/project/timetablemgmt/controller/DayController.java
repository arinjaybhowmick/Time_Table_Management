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

import com.project.timetablemgmt.dto.DayDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.service.DayService;
import com.project.timetablemgmt.validator.DayValidator;

@RestController
@RequestMapping("/api/day")
public class DayController {
    
    @Autowired
    private DayService service;

    @Autowired
    private DayValidator validator;

    @GetMapping
    public ResponseEntity<List<DayDTO>> getAll() {
        List<DayDTO> days = service.getAll();
        return new ResponseEntity<>(days, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DayDTO> getById(@PathVariable Short id) {
        Optional<DayDTO> day = service.getById(id);
        return day.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<DayDTO> create(@RequestBody DayDTO day) throws AbstractException {
        validator.validate(day);

        DayDTO createdDay = service.create(day);
        return new ResponseEntity<>(createdDay, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DayDTO> update(@PathVariable Short id, @RequestBody DayDTO day) throws AbstractException {
        validator.validate(day);

        DayDTO updatedDay = service.update(id, day);
        return new ResponseEntity<>(updatedDay, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DayDTO> delete(@PathVariable Short id) {
        DayDTO deletedDay = service.delete(id);
        return new ResponseEntity<>(deletedDay, HttpStatus.OK);
    }
}
