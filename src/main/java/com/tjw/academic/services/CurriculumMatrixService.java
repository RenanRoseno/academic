package com.tjw.academic.services;

import com.tjw.academic.repositories.CurriculumMatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumMatrixService {
    @Autowired
    CurriculumMatrixRepository curriculumMatrixRepository;
}
