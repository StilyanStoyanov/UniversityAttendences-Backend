package com.UniversityAttendences.service;
import com.UniversityAttendences.dto.StudentResponseDTO;
import com.UniversityAttendences.entity.Specialty;
import com.UniversityAttendences.entity.Student;
import com.UniversityAttendences.exception.customException.SpecialtyNotFound;
import com.UniversityAttendences.exception.customException.StudentNotFound;
import com.UniversityAttendences.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    public static final String STUDENT_NOT_FOUND = "The student that you are searching for is not part of the our system";
    public static final String SPECIALTY_NOT_FOUND = "The specialty you are looking for is not exist";
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ModelMapper modelMapper;

    public StudentResponseDTO getStudentById(String id) throws StudentNotFound{
        Student student = serviceRepository.getStudentRepository().findById(id).orElseThrow(()-> new StudentNotFound(STUDENT_NOT_FOUND));
        return modelMapper.map(student, StudentResponseDTO.class);
    }

    public List<StudentResponseDTO> getAllStudents(){
        List<Student> students = serviceRepository.getStudentRepository().findAll();
        return students.stream().map(student -> modelMapper.map(student, StudentResponseDTO.class)).collect(Collectors.toList());
    }

    public void deleteStudentById(String id) throws Exception{
        StudentResponseDTO user = getStudentById(id);
        serviceRepository.getStudentRepository().deleteById(user.getId());
    }

    public List<Integer> getAllStudentsGroupBySpecialtyId(String specialtyId, int semester){
        Specialty specialty = serviceRepository.getSpecialtyRepository().findById(specialtyId)
                .orElseThrow(() -> new SpecialtyNotFound(SPECIALTY_NOT_FOUND));

        List<Student> students = serviceRepository.getStudentRepository()
                .findAllBySpecialtyId(specialty.getId(), semester);

        List<Integer> groups = students
                .stream()
                .map(Student::getStudentGroup)
                .collect(Collectors.toList());

        return groups;
    }

    public List<StudentResponseDTO> getAllStudentsBySpecialtyIdSemesterAndGroup(String specialtyId, int group, int semester){
        Specialty specialty = serviceRepository.getSpecialtyRepository().findById(specialtyId)
                .orElseThrow(() -> new SpecialtyNotFound(SPECIALTY_NOT_FOUND));
        List<Student> students = serviceRepository.getStudentRepository()
                .findAllBySpecialtyIdAndStudentGroupAndSemesterOrderByFullNameAsc(specialty.getId(), group, semester);
        return students.stream().map(student -> modelMapper.map(student, StudentResponseDTO.class)).collect(Collectors.toList());
    }
}
