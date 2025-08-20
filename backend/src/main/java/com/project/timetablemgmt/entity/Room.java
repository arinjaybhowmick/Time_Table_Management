package com.project.timetablemgmt.entity;

import com.project.timetablemgmt.framework.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "TT_ROOM")
public class Room extends BaseEntity<Long> {

    @Column(name = "room_number", length = 5, nullable = false, unique = true)
    private String roomNumber;

    @Column(name = "display_name", length = 20, nullable = false, unique = true)
    private String displayName;

    @Column(name = "capacity", nullable = false)
    private Short capacity;

    @OneToOne
    @JoinColumn(name = "grade_id", nullable = true)
    private Grade grade;

}
