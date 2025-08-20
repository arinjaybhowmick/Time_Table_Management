package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.entity.Room;
import com.project.timetablemgmt.mapper.RoomMapper;
import com.project.timetablemgmt.repository.RoomRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMapper roomMapper;

    public List<RoomDTO> getAll() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                   .map(roomMapper::convertEntitytoDTO)
                   .collect(Collectors.toList());
    }

    public Optional<RoomDTO> getById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom.map(roomMapper::convertEntitytoDTO);
    }

    public RoomDTO create(RoomDTO roomDTO) {
        Room room;

        try{
            room = roomMapper.convertDTOtoEntity(roomDTO);
            room = roomRepository.save(room);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return roomMapper.convertEntitytoDTO(room);
    }

    public RoomDTO update(Long id, RoomDTO roomDTO) {        
        Room room;    
        
        try{
            room = roomMapper.convertDTOtoEntity(roomDTO);
            room.setId(id);

            room = roomRepository.save(room);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return roomMapper.convertEntitytoDTO(room);
    }

    public RoomDTO delete(Long id) {
        RoomDTO roomDTO = getById(id).orElse(null);
        roomRepository.deleteById(id);
        return roomDTO;
    }
}
