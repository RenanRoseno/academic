package com.tjw.academic.controllers;

import com.tjw.academic.models.Course;
import com.tjw.academic.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping
    List<Course> listAll() {
        return courseService.listAll();
    }

    @GetMapping("{id}")
    Course getById(@PathVariable Long id) throws Exception {
        return courseService.getById(id);
    }

    @PostMapping
    Course save(@RequestBody Course course) throws Exception {
        return courseService.save(course);
    }

    @PutMapping("{id}")
    Course update(@RequestBody Course course, @PathVariable Long id) throws Exception {
        return courseService.update(course, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}
