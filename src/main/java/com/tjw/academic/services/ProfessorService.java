package com.tjw.academic.services;

import com.tjw.academic.models.Professor;
import com.tjw.academic.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> listAll() {
        return professorRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Optional<Professor> getById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor save(Professor professor) throws Exception {
        this.validateExistingProfessor(professor);
        return professorRepository.save(professor);
    }

    private void validateExistingProfessor(Professor professor) throws Exception {
        if (this.professorRepository.findByCpf(professor.getCpf()).size() > 0) {
            throw new Exception("CPF já cadastrado.");
        }
        
        if (this.professorRepository.findByEmail(professor.getEmail()).size() > 0) {
            throw new Exception("Email já cadastrado.");
        }

        if (this.professorRepository.findByRegister(professor.getRegister()).size() > 0) {
            throw new Exception("RG já cadastrado.");
        }
    }
}
