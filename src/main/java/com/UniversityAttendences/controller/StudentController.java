package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.StudentsResponseDTO;
import com.UniversityAttendences.entity.Specialty;
import com.UniversityAttendences.entity.Student;
import com.UniversityAttendences.exception.customException.StudentNotFound;
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

    @GetMapping
    public ResponseEntity<String> testController () {
        return ResponseEntity.ok("Hi I am a student!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentsResponseDTO> gerStudentById (@PathVariable("id") String id) throws StudentNotFound {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentsResponseDTO>> getAllStudents (){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudentById (@PathVariable("id") String id) throws Exception {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

}
