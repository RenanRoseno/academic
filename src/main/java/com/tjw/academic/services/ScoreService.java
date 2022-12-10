package com.tjw.academic.services;

import com.tjw.academic.exception.UserNotFoundException;
import com.tjw.academic.models.Score;
import com.tjw.academic.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    public List<Score> listAll() {
        return scoreRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Score getById(Long id) throws Exception {
        return scoreRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar o curso com o id: " + id.toString() + "."));
    }

    public Score save(Score score) throws Exception {
        return scoreRepository.save(score);
    }

    public Score update(Score updatedScore, Long id) throws Exception {
        return this.scoreRepository.findById(id)
                .map(scoreDB -> {
                    scoreDB = updatedScore;
                    return scoreRepository.save(scoreDB);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void delete(Long id) {
        if (!scoreRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        scoreRepository.deleteById(id);
    }
}
