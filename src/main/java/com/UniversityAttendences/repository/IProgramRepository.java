package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgramRepository extends JpaRepository<Program, String> {

}
