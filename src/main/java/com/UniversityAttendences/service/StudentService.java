package com.UniversityAttendences.service;
import com.UniversityAttendences.entity.Student;
import com.UniversityAttendences.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    ServiceRepository serviceRepository;

    public Student getStudentById(String id) throws Exception{
        return serviceRepository.getStudentRepository().findById(id).orElseThrow(()-> new Exception("User not found"));
    }

    public List<Student> getAllStudents(){
        return serviceRepository.getStudentRepository().findAll();
    }

    public void deleteStudentById(String id) throws Exception{
        Student user = getStudentById(id);
        serviceRepository.getStudentRepository().deleteById(user.getId());
    }
}
