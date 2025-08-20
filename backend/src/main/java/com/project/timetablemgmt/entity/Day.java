package com.project.timetablemgmt.entity;

import com.project.timetablemgmt.framework.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TT_DAY")
public class Day extends BaseEntity<Short> {

    @Column(name = "display_name", length = 10, nullable = false, unique = true)
    private String displayName;

    @Column(name = "short_name", length = 3, nullable = false, unique = true)
    private String shortName;

}
