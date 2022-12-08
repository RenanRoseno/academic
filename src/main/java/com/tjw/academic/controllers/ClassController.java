package com.tjw.academic.controllers;

import com.tjw.academic.models.Class;
import com.tjw.academic.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes/")
public class ClassController {
    @Autowired
    ClassService classService;

    @GetMapping
    List<Class> listAll() {
        return classService.listAll();
    }

    @GetMapping("{id}")
    Class getById(@PathVariable Long id) throws Exception {
        return classService.getById(id);
    }

    @PostMapping
    Class save(@RequestBody Class classParam) throws Exception {
        return classService.save(classParam);
    }

    @PutMapping("{id}")
    Class update(@RequestBody Class classParam, @PathVariable Long id) throws Exception {
        return classService.update(classParam, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        classService.delete(id);
    }
}
