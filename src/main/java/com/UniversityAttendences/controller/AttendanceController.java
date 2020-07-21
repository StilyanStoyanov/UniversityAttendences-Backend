package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.AttendanceResponseDTO;
import com.UniversityAttendences.dto.UpdateAttendanceRequestDTO;
import com.UniversityAttendences.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@CrossOrigin
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping
    public ResponseEntity<List<AttendanceResponseDTO>> getAttendances
            (@RequestParam String studentId, @RequestParam int semester) {
        return ResponseEntity.ok(attendanceService.getAttendances(studentId, semester));
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @GetMapping("/filter")
    public ResponseEntity<AttendanceResponseDTO> getAttendancesBySubject
            (@RequestParam String studentId,
             @RequestParam int semester,
             @RequestParam String subjectId) {
        return ResponseEntity.ok(attendanceService.getAttendancesBySubject(studentId, semester, subjectId));
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @PutMapping
    public ResponseEntity<AttendanceResponseDTO> updateAttendance(@RequestBody UpdateAttendanceRequestDTO request){
        return ResponseEntity.ok(attendanceService.updateAttendance(request));
    }

}
