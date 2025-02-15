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

import com.project.timetablemgmt.dto.SubjectDTO;
import com.project.timetablemgmt.service.SubjectService;

import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    
    @Autowired
    private SubjectService service;

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAll() {
        List<SubjectDTO> subjects = service.getAll();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDTO> getById(@PathVariable Long id) {
        Optional<SubjectDTO> subject = service.getById(id);
        return subject.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<SubjectDTO> create(@RequestBody SubjectDTO subject) throws InvalidAttributeValueException, ConstraintViolationException {
        SubjectDTO createdSubject = service.create(subject);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SubjectDTO> update(@PathVariable Long id, @RequestBody SubjectDTO subject) throws InvalidAttributeValueException, ConstraintViolationException {
        SubjectDTO updatedSubject = service.update(id, subject);
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SubjectDTO> delete(@PathVariable Long id) {
        SubjectDTO deletedSubject = service.delete(id);
        return new ResponseEntity<>(deletedSubject, HttpStatus.OK);
    }
}
