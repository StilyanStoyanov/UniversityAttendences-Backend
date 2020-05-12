package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance, String> {

}
