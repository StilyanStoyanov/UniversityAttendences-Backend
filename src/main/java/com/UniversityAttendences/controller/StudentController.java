package com.UniversityAttendences.controller;

import com.UniversityAttendences.entity.Specialty;
import com.UniversityAttendences.entity.Student;
import com.UniversityAttendences.repository.ServiceRepository;
import com.UniversityAttendences.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Student> gerStudentById (@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents () throws Exception {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/all/spec")
    public ResponseEntity<List<Specialty>> getAllSpecialties () throws Exception {
        return ResponseEntity.ok(serviceRepository.getSpecialtyRepository().findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudentById (@PathVariable("id") String id) throws Exception {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

}
