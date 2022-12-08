package com.tjw.academic.controllers;

import com.tjw.academic.models.Discipline;
import com.tjw.academic.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines/")
public class DisciplineController {
    @Autowired
    DisciplineService disciplineService;

    @GetMapping
    List<Discipline> listAll() {
        return disciplineService.listAll();
    }

    @GetMapping("{id}")
    Discipline getById(@PathVariable Long id) throws Exception {
        return disciplineService.getById(id);
    }

    @PostMapping
    Discipline save(@RequestBody Discipline discipline) throws Exception {
        return disciplineService.save(discipline);
    }

    @PutMapping("{id}")
    Discipline update(@RequestBody Discipline discipline, @PathVariable Long id) throws Exception {
        return disciplineService.update(discipline, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        disciplineService.delete(id);
    }
}
