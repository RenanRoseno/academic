package com.tjw.academic.services;

import com.tjw.academic.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {
    @Autowired
    DisciplineRepository disciplineRepository;
}