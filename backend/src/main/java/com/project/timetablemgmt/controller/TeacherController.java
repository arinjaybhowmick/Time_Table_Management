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

import com.project.timetablemgmt.dto.TeacherDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.service.TeacherService;
import com.project.timetablemgmt.validator.TeacherValidator;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    
    @Autowired
    private TeacherService service;

    @Autowired
    private TeacherValidator validator;

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAll() {
        List<TeacherDTO> teachers = service.getAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getById(@PathVariable Long id) {
        Optional<TeacherDTO> teacher = service.getById(id);
        return teacher.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<TeacherDTO> create(@RequestBody TeacherDTO teacher) throws AbstractException {
        validator.validate(teacher);

        TeacherDTO createdTeacher = service.create(teacher);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherDTO> update(@PathVariable Long id, @RequestBody TeacherDTO teacher) throws AbstractException {
        validator.validate(teacher);

        TeacherDTO updatedTeacher = service.update(id, teacher);
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TeacherDTO> delete(@PathVariable Long id) {
        TeacherDTO deletedTeacher = service.delete(id);
        return new ResponseEntity<>(deletedTeacher, HttpStatus.OK);
    }
}
