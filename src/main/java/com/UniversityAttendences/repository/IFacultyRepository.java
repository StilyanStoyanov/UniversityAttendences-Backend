package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacultyRepository extends JpaRepository<Faculty, String> {

}
