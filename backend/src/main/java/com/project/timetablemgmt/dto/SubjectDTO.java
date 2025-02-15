package com.project.timetablemgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    private String code;
    private String name;
    private String optional;
    private Short periods;
}
