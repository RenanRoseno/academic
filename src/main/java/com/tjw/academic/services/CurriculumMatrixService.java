package com.tjw.academic.services;

import com.tjw.academic.exception.UserNotFoundException;
import com.tjw.academic.models.Course;
import com.tjw.academic.models.CurriculumMatrix;
import com.tjw.academic.repositories.CourseRepository;
import com.tjw.academic.repositories.CurriculumMatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumMatrixService {
    @Autowired
    CurriculumMatrixRepository curriculumMatrixRepository;

    public List<CurriculumMatrix> listAll() {
        return curriculumMatrixRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public CurriculumMatrix getById(Long id) throws Exception {
        return curriculumMatrixRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar a matriz curricular com o id: " + id.toString() + "."));
    }

    public CurriculumMatrix save(CurriculumMatrix curriculumMatrix) throws Exception {
        //this.validateExistingProfessor(professor);
        return curriculumMatrixRepository.save(curriculumMatrix);
    }

    public CurriculumMatrix update(CurriculumMatrix updatedCurriculumMatr, Long id) throws Exception {
        //this.validateExistingProfessor(updatedProfessor);
        return this.curriculumMatrixRepository.findById(id)
                .map(curriculumMatrixDB -> {
                    curriculumMatrixDB = updatedCurriculumMatr;
                    return curriculumMatrixRepository.save(curriculumMatrixDB);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void delete(Long id) {
        if (!curriculumMatrixRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        curriculumMatrixRepository.deleteById(id);
    }
}
