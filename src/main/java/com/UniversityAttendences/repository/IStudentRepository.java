package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findByFacultyNumberAndEgn(String username, String password);

    @Query(value = "SELECT * FROM students where specialty_id = :specialty and semester = :semester GROUP BY student_group", nativeQuery = true)
    List<Student> findAllBySpecialtyId(@Param("specialty") String specialtyId, @Param("semester") int semester);

    List<Student> findAllBySpecialtyIdAndStudentGroupAndSemester(String specialtyId, int group, int semester);
}
