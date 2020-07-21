package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.StudentResponseDTO;
import com.UniversityAttendences.exception.customException.StudentNotFound;
import com.UniversityAttendences.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById (@PathVariable("id") String id) throws StudentNotFound {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents (){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudentById (@PathVariable("id") String id) throws Exception {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping("/group")
    public ResponseEntity<List<Integer>> getGroupBySpecialtyId (
            @RequestParam("specialtyId") String id,
            @RequestParam(value = "semester") int semester)
        throws StudentNotFound {
        return ResponseEntity.ok(studentService.getAllStudentsGroupBySpecialtyId(id, semester));
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping("/all/filter")
    public ResponseEntity<List<StudentResponseDTO>> getAllByGroupSemesterAndSpecialty (
            @RequestParam("specialtyId") String id,
            @RequestParam(value = "semester") int semester,
            @RequestParam(value = "group") int group)
            throws StudentNotFound {
        return ResponseEntity.ok(studentService.getAllStudentsBySpecialtyIdSemesterAndGroup(id, group, semester));
    }

}
