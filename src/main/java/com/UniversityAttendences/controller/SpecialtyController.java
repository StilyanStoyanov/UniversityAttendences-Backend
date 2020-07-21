package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.SpecialtyDTO;
import com.UniversityAttendences.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialty")
@CrossOrigin
public class SpecialtyController {

    @Autowired
    SpecialtyService specialtyService;

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping("/all")
    public ResponseEntity<List<SpecialtyDTO>> getAllStudents (){
        return ResponseEntity.ok(specialtyService.getAllSpecialties());
    }

}
