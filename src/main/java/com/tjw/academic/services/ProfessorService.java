package com.tjw.academic.services;

import com.tjw.academic.exception.UserNotFoundException;
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

    public Professor getById(Long id) {
        return professorRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public Professor save(Professor professor) throws Exception {
        this.validateExistingProfessor(professor);
        return professorRepository.save(professor);
    }

    public Professor update(Professor updatedProfessor, Long id) throws Exception {
        this.validateExistingProfessor(updatedProfessor);
        return this.professorRepository.findById(id)
                .map(professor -> {
                    professor = updatedProfessor;
                    return professorRepository.save(professor);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void delete(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        professorRepository.deleteById(id);
    }

    private void validateExistingProfessor(Professor professor) throws Exception {
        Long idProfessor = professor.getId();
        if (this.professorRepository.findByCpf(professor.getCpf(), idProfessor).size() > 0) {
            throw new Exception("CPF já cadastrado.");
        }

        if (this.professorRepository.findByEmail(professor.getEmail(), idProfessor).size() > 0) {
            throw new Exception("Email já cadastrado.");
        }

        if (this.professorRepository.findByRegister(professor.getRegister(), idProfessor).size() > 0) {
            throw new Exception("RG já cadastrado.");
        }
    }


}
