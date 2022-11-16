package com.jwt.academic.controllers;

import com.jwt.academic.models.Professor;
import com.jwt.academic.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professors/")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @GetMapping
    public List<Professor> listAll() {
        return professorService.listAll();
    }

    @GetMapping("{id}")
    public Optional<Professor> getById(@PathVariable Long id) {
        return professorService.getById(id);
    }

    @PostMapping
    public Professor save(@RequestBody Professor professor) {
        return professorService.save(professor);
    }
}
