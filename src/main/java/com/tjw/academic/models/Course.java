package com.tjw.academic.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_couses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "kind_course")
    private Long kindCourse;

    @OneToMany(mappedBy = "course")
    private List<Class> classes;

    @JsonBackReference
    @OneToMany(mappedBy = "course")
    private List<CurriculumMatrix> curriculumMatrices;

    @Transient
    private String kindCourseDescription;
}
