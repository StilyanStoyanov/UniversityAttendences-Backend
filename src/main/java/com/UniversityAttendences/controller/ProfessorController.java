package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.ProfessorResponseDTO;
import com.UniversityAttendences.exception.customException.ProfessorNotFound;
import com.UniversityAttendences.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfessorController {
    
    @Autowired
    ProfessorService professorService;


    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> gerProfessorById (@PathVariable("id") String id) throws ProfessorNotFound {
        return ResponseEntity.ok(professorService.getProfessorById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProfessorResponseDTO>> getAllProfessors (){
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProfessorById (@PathVariable("id") String id){
        professorService.deleteProfessorById(id);
        return ResponseEntity.ok().build();
    }
}
