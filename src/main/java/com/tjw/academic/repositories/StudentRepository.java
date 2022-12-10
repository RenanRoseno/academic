package com.tjw.academic.repositories;

import com.tjw.academic.models.Professor;
import com.tjw.academic.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.studentRegister = ?1 AND s.id <> ?2")
    List<Student> findByRegisterId(String register, Long id);

    @Query("SELECT s FROM Student s WHERE s.studentRegister = ?1")
    List<Student> findByRegister(String register);
}
