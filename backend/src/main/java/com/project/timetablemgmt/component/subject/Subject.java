package com.project.timetablemgmt.component.subject;

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
@Table(name = "TT_SUBJECT")
public class Subject extends BaseEntity<Long> {

    @Column(name = "code", length = 6, nullable = false, unique = true)
    private String code;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "optional", length = 1, nullable = false)
    private String optional;

    @Column(name = "periods", nullable = false)
    private Short periods;

}
