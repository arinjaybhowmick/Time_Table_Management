package com.project.timetablemgmt.controller;

import java.util.List;
import java.util.Optional;

import javax.management.InvalidAttributeValueException;

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

import com.project.timetablemgmt.dto.TimetableDTO;
import com.project.timetablemgmt.service.TimetableService;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {
    
    @Autowired
    private TimetableService service;

    @GetMapping
    public ResponseEntity<List<TimetableDTO>> getAll() {
        List<TimetableDTO> timetables = service.getAll();
        return new ResponseEntity<>(timetables, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimetableDTO> getById(@PathVariable Long id) {
        Optional<TimetableDTO> timetable = service.getById(id);
        return timetable.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<TimetableDTO> create(@RequestBody TimetableDTO timetable) throws InvalidAttributeValueException {
        TimetableDTO createdTimetable = service.create(timetable);
        return new ResponseEntity<>(createdTimetable, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TimetableDTO> update(@PathVariable Long id, @RequestBody TimetableDTO timetable) throws InvalidAttributeValueException {
        TimetableDTO updatedTimetable = service.update(id, timetable);
        return new ResponseEntity<>(updatedTimetable, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TimetableDTO> delete(@PathVariable Long id) {
        TimetableDTO deletedTimetable = service.delete(id);
        return new ResponseEntity<>(deletedTimetable, HttpStatus.OK);
    }
}
