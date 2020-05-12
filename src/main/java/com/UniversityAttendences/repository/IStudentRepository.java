package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, String> {

    List<Student> findAll();

    Optional<Student> findById(String id);

    void deleteById(String s);

    Optional<Student> findByFullNameAndEgn(String username, String password);
}
