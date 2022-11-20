package com.tjw.academic.repositories;

import com.tjw.academic.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT p FROM Professor p WHERE p.cpf = ?1 AND p.id <> ?2")
    List<Professor> findByCpf(String cpf, Long id);

    @Query("SELECT p FROM Professor p WHERE p.email = ?1 AND p.id <> ?2")
    List<Professor> findByEmail(String email, Long id);

    @Query("SELECT p FROM Professor p WHERE p.register = ?1 AND p.id <> ?2 ")
    List<Professor> findByRegister(String register, Long id);
}
