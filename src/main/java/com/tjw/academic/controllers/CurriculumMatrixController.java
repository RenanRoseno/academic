package com.tjw.academic.controllers;

import com.tjw.academic.models.CurriculumMatrix;
import com.tjw.academic.services.CurriculumMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curriculum-matrices/")
public class CurriculumMatrixController {
    @Autowired
    CurriculumMatrixService curriculumMatrixService;

    @GetMapping
    List<CurriculumMatrix> listAll() {
        return curriculumMatrixService.listAll();
    }

    @GetMapping("{id}")
    CurriculumMatrix getById(@PathVariable Long id) throws Exception {
        return curriculumMatrixService.getById(id);
    }

    @PostMapping
    CurriculumMatrix save(@RequestBody CurriculumMatrix curriculumMatrix) throws Exception {
        return curriculumMatrixService.save(curriculumMatrix);
    }

    @PutMapping("{id}")
    CurriculumMatrix update(@RequestBody CurriculumMatrix curriculumMatrix, @PathVariable Long id) throws Exception {
        return curriculumMatrixService.update(curriculumMatrix, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        curriculumMatrixService.delete(id);
    }
}
