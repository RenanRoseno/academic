package com.tjw.academic.controllers;

import com.tjw.academic.models.Score;
import com.tjw.academic.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores/")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @GetMapping
    List<Score> listAll() {
        return scoreService.listAll();
    }

    @GetMapping("{id}")
    Score getById(@PathVariable Long id) throws Exception {
        return scoreService.getById(id);
    }

    @PostMapping
    Score save(@RequestBody Score score) throws Exception {
        return scoreService.save(score);
    }

    @PutMapping("{id}")
    Score update(@RequestBody Score score, @PathVariable Long id) throws Exception {
        return scoreService.update(score, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        scoreService.delete(id);
    }
}
