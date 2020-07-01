package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProgramRepository extends JpaRepository<Program, String> {

    List<Program> findAllBySpecialtyIdAndSemester(String specialtyId, int semester);

    List<Program> findAllByProfessorIdAndSpecialtyIdAndSemester(String professorId, String specialtyId, int semester);

    List<Program> findAllByProfessorIdAndSpecialtyId(String professorId, String specialtyId);

    List<Program> findAllByProfessorIdAndSemester(String professorId, int semester);

    List<Program> findAllByProfessorId(String professorId);

}
