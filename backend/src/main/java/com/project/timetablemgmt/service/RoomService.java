package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.entity.Room;
import com.project.timetablemgmt.mapper.RoomMapper;
import com.project.timetablemgmt.repository.GradeRepository;
import com.project.timetablemgmt.repository.RoomRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public List<RoomDTO> getAll() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                   .map(RoomMapper::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<RoomDTO> getById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom.map(RoomMapper::toDTO);
    }

    public RoomDTO create(RoomDTO roomDTO) throws InvalidAttributeValueException {
        String msg = validateRoom(roomDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Room room;

        try{

            Grade grade = (!roomDTO.getClassName().isEmpty()) ? 
                                gradeRepository.findByClassName(roomDTO.getClassName()) : null;

            room = RoomMapper.toEntity(roomDTO,grade);
            room = roomRepository.save(room);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return RoomMapper.toDTO(room);
    }

    public RoomDTO update(Long id, RoomDTO roomDTO) throws InvalidAttributeValueException {
        String msg = validateRoom(roomDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Room room;    
        
        try{

            Grade grade = (!roomDTO.getClassName().isEmpty()) ? 
                                gradeRepository.findByClassName(roomDTO.getClassName()) : null;

            room = RoomMapper.toEntity(roomDTO,grade);
            room.setId(id);

            room = roomRepository.save(room);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return RoomMapper.toDTO(room);
    }

    public RoomDTO delete(Long id) {
        RoomDTO roomDTO = getById(id).orElse(null);
        roomRepository.deleteById(id);
        return roomDTO;
    }

    private String validateRoom(RoomDTO roomDTO) {
        
        return null;
    }
}
