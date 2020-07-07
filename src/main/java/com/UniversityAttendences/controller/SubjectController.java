package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.SubjectResponseDTO;
import com.UniversityAttendences.exception.customException.StudentNotFound;
import com.UniversityAttendences.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> getStudentById (@PathVariable("id") String id) throws StudentNotFound {
        return ResponseEntity.ok(subjectService.getSubjectById(id));
    }
}
