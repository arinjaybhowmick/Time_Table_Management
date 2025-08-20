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
@Table(name = "TT_GRADE")
public class Grade extends BaseEntity<Long> {

    @Column(name = "class_name", length = 15, nullable = false, unique = true)
    private String className;

    @Column(name = "strength", nullable = false)
    private Short strength;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = true)
    private Teacher teacher;

}
