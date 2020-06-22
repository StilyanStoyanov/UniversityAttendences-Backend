package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findByFacultyNumberAndEgn(String username, String password);
}
