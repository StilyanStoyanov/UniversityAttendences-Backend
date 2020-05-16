package com.UniversityAttendences.service;
import com.UniversityAttendences.dto.StudentsResponseDTO;
import com.UniversityAttendences.entity.Student;
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
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ModelMapper modelMapper;

    public StudentsResponseDTO getStudentById(String id) throws StudentNotFound{
        Student student = serviceRepository.getStudentRepository().findById(id).orElseThrow(()-> new StudentNotFound(STUDENT_NOT_FOUND));
        return modelMapper.map(student, StudentsResponseDTO.class);
    }

    public List<StudentsResponseDTO> getAllStudents(){
        List<Student> students = serviceRepository.getStudentRepository().findAll();
        return students.stream().map(student -> modelMapper.map(student, StudentsResponseDTO.class)).collect(Collectors.toList());
    }

    public void deleteStudentById(String id) throws Exception{
        StudentsResponseDTO user = getStudentById(id);
        serviceRepository.getStudentRepository().deleteById(user.getId());
    }
}
