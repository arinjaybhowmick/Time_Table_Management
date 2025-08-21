package com.project.timetablemgmt.component.timetable;

import com.project.timetablemgmt.component.day.Day;
import com.project.timetablemgmt.component.grade.Grade;
import com.project.timetablemgmt.component.period.Period;
import com.project.timetablemgmt.component.room.Room;
import com.project.timetablemgmt.component.teaches.Teaches;
import com.project.timetablemgmt.framework.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TIME_TABLE")
public class Timetable extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    private Day day;

    @ManyToOne
    @JoinColumn(name = "period_id", nullable = false)
    private Period period;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = true)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = true)
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "teaches_id", nullable = true)
    private Teaches teaches;
}
