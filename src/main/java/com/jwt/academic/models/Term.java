package com.jwt.academic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_terms")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String year;

    private Long stage;

    @OneToMany(mappedBy = "term")
    private List<Class> classes;
}
