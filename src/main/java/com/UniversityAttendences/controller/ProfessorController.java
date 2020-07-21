package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.ProfessorResponseDTO;
import com.UniversityAttendences.dto.ProgramResponseDTO;
import com.UniversityAttendences.exception.customException.ProfessorNotFound;
import com.UniversityAttendences.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfessorController {
    
    @Autowired
    ProfessorService professorService;

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> gerProfessorById (@PathVariable("id") String id) throws ProfessorNotFound {
        return ResponseEntity.ok(professorService.getProfessorById(id));
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping
    public ResponseEntity<Set<ProfessorResponseDTO>> getAllProfessors
            (@RequestParam String specialtyId, @RequestParam int semester) {
        return ResponseEntity.ok(professorService.getAllProfessors(specialtyId, semester));
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/all")
    public ResponseEntity<List<ProfessorResponseDTO>> getAllProfessors (){
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProfessorById (@PathVariable("id") String id){
        professorService.deleteProfessorById(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping("/{id}/program")
    public ResponseEntity<List<ProgramResponseDTO>> gerProfessorsProgramById (
            @PathVariable("id") String id,
            @RequestParam(required = false) String specialtyId,
            @RequestParam(required = false, defaultValue = "0") int semester
    ) throws ProfessorNotFound {
        return ResponseEntity.ok(professorService.getProfessorProgramById(id, specialtyId, semester));
    }
}
