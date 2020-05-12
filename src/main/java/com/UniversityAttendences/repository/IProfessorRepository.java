package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, String> {

}
