package com.jwt.academic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "tb_scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
