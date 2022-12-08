package com.tjw.academic.controllers;

import com.tjw.academic.models.Student;
import com.tjw.academic.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    List<Student> listAll() {
        return studentService.listAll();
    }

    @GetMapping("{id}")
    Student getById(@PathVariable Long id) throws Exception {
        return studentService.getById(id);
    }

    @PostMapping
    Student save(@RequestBody Student student) throws Exception {
        return studentService.save(student);
    }

    @PutMapping("{id}")
    Student update(@RequestBody Student student, @PathVariable Long id) throws Exception {
        return studentService.update(student, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
