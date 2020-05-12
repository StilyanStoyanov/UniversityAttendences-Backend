package com.UniversityAttendences.repository;

import com.UniversityAttendences.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISubjectRepository extends JpaRepository<Subject, String> {

}
