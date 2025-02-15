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

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.service.RoomService;

import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    
    @Autowired
    private RoomService service;

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAll() {
        List<RoomDTO> rooms = service.getAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getById(@PathVariable Long id) {
        Optional<RoomDTO> room = service.getById(id);
        return room.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<RoomDTO> create(@RequestBody RoomDTO room) throws InvalidAttributeValueException, ConstraintViolationException {
        RoomDTO createdRoom = service.create(room);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoomDTO> update(@PathVariable Long id, @RequestBody RoomDTO room) throws InvalidAttributeValueException, ConstraintViolationException {
        RoomDTO updatedRoom = service.update(id, room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RoomDTO> delete(@PathVariable Long id) {
        RoomDTO deletedRoom = service.delete(id);
        return new ResponseEntity<>(deletedRoom, HttpStatus.OK);
    }
}
