package com.tjw.academic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_curriculum_matrices")
public class CurriculumMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vigency_date")
    @Temporal(TemporalType.DATE)
    private Calendar vigencyDate;

    @ManyToMany
    private List<Discipline> disciplines;

    @ManyToOne
    private Course course;
}
