package com.jwt.academic.services;

import com.jwt.academic.models.Professor;
import com.jwt.academic.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> listAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }
}
