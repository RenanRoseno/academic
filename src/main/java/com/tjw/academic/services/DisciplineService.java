package com.tjw.academic.services;

import com.tjw.academic.exception.UserNotFoundException;
import com.tjw.academic.models.Discipline;
import com.tjw.academic.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {
    @Autowired
    DisciplineRepository disciplineRepository;

    public List<Discipline> listAll() {
        return disciplineRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Discipline getById(Long id) throws Exception {
        return disciplineRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar a disciplina com o id: " + id.toString() + "."));
    }

    public Discipline save(Discipline discipline) throws Exception {
        //this.validateExistingProfessor(professor);
        return disciplineRepository.save(discipline);
    }

    public Discipline update(Discipline disciplineUpdated, Long id) throws Exception {
        //this.validateExistingProfessor(updatedProfessor);
        return this.disciplineRepository.findById(id)
                .map(disciplineDB -> {
                    disciplineDB = disciplineUpdated;
                    return disciplineRepository.save(disciplineDB);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void delete(Long id) {
        if (!disciplineRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        disciplineRepository.deleteById(id);
    }
}
