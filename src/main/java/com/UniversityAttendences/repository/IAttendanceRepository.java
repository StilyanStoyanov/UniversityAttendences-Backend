package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance, String> {

    List<Attendance> findAllByStudentIdAndSemester(String studentId, int semester);

    Attendance findByStudentIdAndSemesterAndSubjectId(String studentId, int semester, String subjectId);

}
