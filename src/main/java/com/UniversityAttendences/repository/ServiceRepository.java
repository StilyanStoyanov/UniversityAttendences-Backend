package com.UniversityAttendences.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ServiceRepository {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ISubjectRepository subjectRepository;

    @Autowired
    private ISpecialtyRepository specialtyRepository;

    @Autowired
    private IProgramRepository programRepository;

    @Autowired
    private IProfessorRepository professorRepository;

    @Autowired
    private IFacultyRepository facultyRepository;

    @Autowired
    private IAttendanceRepository attendanceRepository;
}
