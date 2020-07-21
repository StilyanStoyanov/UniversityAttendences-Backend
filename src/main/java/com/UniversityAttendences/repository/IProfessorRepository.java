package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, String> {

    Optional<Professor> findByEmailAndPassword(String username, String password);

    Optional<Professor> findByEmail(String username);

    List<Professor> findAllByOrderByFullNameAsc();

}
