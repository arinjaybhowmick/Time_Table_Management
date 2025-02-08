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
@Table(name = "TT_GRADE")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "standard", length = 15, nullable = false, unique = true)
    private String standard;

    @Column(name = "section", length = 5, nullable = false)
    private String section;

    @Column(name = "strength", nullable = false)
    private Short strength;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = true)
    private Teacher teacher;

}
