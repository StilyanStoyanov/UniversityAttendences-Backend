package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.StudentResponseDTO;
import com.UniversityAttendences.exception.customException.StudentNotFound;
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
    public ResponseEntity<StudentResponseDTO> getStudentById (@PathVariable("id") String id) throws StudentNotFound {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents (){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudentById (@PathVariable("id") String id) throws Exception {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/group")
    public ResponseEntity<List<Integer>> getGroupBySpecialtyId (
            @RequestParam("specialtyId") String id,
            @RequestParam(value = "semester") int semester)
        throws StudentNotFound {
        return ResponseEntity.ok(studentService.getAllStudentsGroupBySpecialtyId(id, semester));
    }

    @GetMapping("/all/filter")
    public ResponseEntity<List<StudentResponseDTO>> getAllByGroupSemesterAndSpecialty (
            @RequestParam("specialtyId") String id,
            @RequestParam(value = "semester") int semester,
            @RequestParam(value = "group") int group)
            throws StudentNotFound {
        return ResponseEntity.ok(studentService.getAllStudentsBySpecialtyIdSemesterAndGroup(id, group, semester));
    }

}
