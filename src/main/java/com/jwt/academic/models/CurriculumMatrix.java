package com.jwt.academic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_curriculum_matrices")
public class CurriculumMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
