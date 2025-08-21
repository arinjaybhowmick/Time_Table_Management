package com.project.timetablemgmt.component.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String roomNumber;
    private String displayName;
    private Short capacity;
    private String className;
}
