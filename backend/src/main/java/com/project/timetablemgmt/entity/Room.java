package com.project.timetablemgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TT_ROOM")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
