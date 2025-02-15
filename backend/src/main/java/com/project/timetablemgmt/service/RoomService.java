package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.entity.Room;
import com.project.timetablemgmt.mapper.RoomMapper;
import com.project.timetablemgmt.repository.RoomRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository repository;

    public List<RoomDTO> getAll() {
        List<Room> rooms = repository.findAll();
        return rooms.stream()
                   .map(RoomMapper::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<RoomDTO> getById(Long id) {
        Optional<Room> optionalRoom = repository.findById(id);
        return optionalRoom.map(RoomMapper::toDTO);
    }

    public RoomDTO create(RoomDTO roomDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateRoom(roomDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Room room = RoomMapper.toEntity(roomDTO);
        try{
            room = repository.save(room);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return RoomMapper.toDTO(room);
    }

    public RoomDTO update(Long id, RoomDTO roomDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateRoom(roomDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Room room = RoomMapper.toEntity(roomDTO);    
        room.setId(id);
        try{
            room = repository.save(room);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
        return RoomMapper.toDTO(room);
    }

    public RoomDTO delete(Long id) {
        RoomDTO roomDTO = getById(id).orElse(null);
        repository.deleteById(id);
        return roomDTO;
    }

    private String validateRoom(RoomDTO roomDTO) {
        
        return null;
    }
}
