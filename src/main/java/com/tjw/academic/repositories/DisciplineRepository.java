package com.tjw.academic.repositories;

import com.tjw.academic.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    @Query("SELECT d FROM Discipline d WHERE d.name = ?1")
    List<Discipline> findByName(String name);

    @Query("SELECT d FROM Discipline d WHERE d.name = ?1 AND d.id <> ?2")
    List<Discipline> findByNameId(String name, Long id);
}
