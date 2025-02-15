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

import com.project.timetablemgmt.dto.GradeDTO;
import com.project.timetablemgmt.service.GradeService;

import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    
    @Autowired
    private GradeService service;

    @GetMapping
    public ResponseEntity<List<GradeDTO>> getAll() {
        List<GradeDTO> grades = service.getAll();
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeDTO> getById(@PathVariable Long id) {
        Optional<GradeDTO> grade = service.getById(id);
        return grade.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<GradeDTO> create(@RequestBody GradeDTO grade) throws InvalidAttributeValueException, ConstraintViolationException {
        GradeDTO createdGrade = service.create(grade);
        return new ResponseEntity<>(createdGrade, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GradeDTO> update(@PathVariable Long id, @RequestBody GradeDTO grade) throws InvalidAttributeValueException, ConstraintViolationException {
        GradeDTO updatedGrade = service.update(id, grade);
        return new ResponseEntity<>(updatedGrade, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GradeDTO> delete(@PathVariable Long id) {
        GradeDTO deletedGrade = service.delete(id);
        return new ResponseEntity<>(deletedGrade, HttpStatus.OK);
    }
}
