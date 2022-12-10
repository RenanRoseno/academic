package com.tjw.academic.services;

import com.tjw.academic.exception.UserNotFoundException;
import com.tjw.academic.models.Student;
import com.tjw.academic.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> listAll() {
        return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Student getById(Long id) throws Exception {
        return studentRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar o curso com o id: " + id.toString() + "."));
    }

    public Student save(Student student) throws Exception {
        this.validateExistingStudent(student);
        return studentRepository.save(student);
    }

    public Student update(Student updatedStudent, Long id) throws Exception {
        this.validateExistingStudent(updatedStudent);
        return this.studentRepository.findById(id)
                .map(studentDB -> {
                    studentDB = updatedStudent;
                    return studentRepository.save(studentDB);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }

    private void validateExistingStudent(Student student) throws Exception {
        Long id = student.getId();

        if(id != null && this.studentRepository.findByRegisterId(student.getStudentRegister(), id).size() > 0){
            throw new Exception("Aluno com esta matricula já foi cadastrado.");
        } else if (this.studentRepository.findByRegister(student.getStudentRegister()).size() > 0){
            throw new Exception("Aluno com esta matricula já foi cadastrado.");
        }
    }
}
