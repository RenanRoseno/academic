package com.jwt.academic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "student_register")
    private String studentRegister;

    private String email;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Calendar birthDate;

    private String phone;

    @ManyToMany
    private List<Discipline> disciplines;

}
