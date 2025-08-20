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

import com.project.timetablemgmt.dto.TeachesDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.service.TeachesService;
import com.project.timetablemgmt.validator.TeachesValidator;

@RestController
@RequestMapping("/api/teaches")
public class TeachesController {
    
    @Autowired
    private TeachesService service;

    @Autowired
    private TeachesValidator validator;

    @GetMapping
    public ResponseEntity<List<TeachesDTO>> getAll() {
        List<TeachesDTO> teaches = service.getAll();
        return new ResponseEntity<>(teaches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeachesDTO> getById(@PathVariable Long id) {
        Optional<TeachesDTO> teaches = service.getById(id);
        return teaches.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<TeachesDTO> create(@RequestBody TeachesDTO teaches) throws AbstractException {
        validator.validate(teaches);

        TeachesDTO createdTeaches = service.create(teaches);
        return new ResponseEntity<>(createdTeaches, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TeachesDTO> update(@PathVariable Long id, @RequestBody TeachesDTO teaches) throws AbstractException {
        validator.validate(teaches);

        TeachesDTO updatedTeaches = service.update(id, teaches);
        return new ResponseEntity<>(updatedTeaches, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TeachesDTO> delete(@PathVariable Long id) {
        TeachesDTO deletedTeaches = service.delete(id);
        return new ResponseEntity<>(deletedTeaches, HttpStatus.OK);
    }
}
