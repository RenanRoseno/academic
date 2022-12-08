package com.tjw.academic.services;

import com.tjw.academic.exception.UserNotFoundException;
import com.tjw.academic.models.Class;
import com.tjw.academic.models.Course;
import com.tjw.academic.repositories.ClassRepository;
import com.tjw.academic.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> listAll() {
        return courseRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Course getById(Long id) throws Exception {
        return courseRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar o curso com o id: " + id.toString() + "."));
    }

    public Course save(Course course) throws Exception {
        //this.validateExistingProfessor(professor);
        return courseRepository.save(course);
    }

    public Course update(Course updatedCourse, Long id) throws Exception {
        //this.validateExistingProfessor(updatedProfessor);
        return this.courseRepository.findById(id)
                .map(courseDB -> {
                    courseDB = updatedCourse;
                    return courseRepository.save(courseDB);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void delete(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        courseRepository.deleteById(id);
    }
}
