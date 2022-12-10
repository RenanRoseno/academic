package com.tjw.academic.services;

import com.tjw.academic.exception.UserNotFoundException;
import com.tjw.academic.models.Class;
import com.tjw.academic.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;

    public List<Class> listAll() {
        List<Class> result = classRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        result.forEach(classroom -> classroom.setCourseDesc(classroom.getCourse().getName()));
        return result;
    }

    public Class getById(Long id) throws Exception {
        return classRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar a turma com o id: " + id.toString() + "."));
    }

    public Class save(Class classSave) throws Exception {
        return classRepository.save(classSave);
    }

    public Class update(Class updatedClass, Long id) throws Exception {
        return this.classRepository.findById(id)
                .map(classBd -> {
                    classBd = updatedClass;
                    return classRepository.save(classBd);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void delete(Long id) {
        if (!classRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        classRepository.deleteById(id);
    }
}
