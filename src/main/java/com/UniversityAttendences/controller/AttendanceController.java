package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.AttendancesResponseDTO;
import com.UniversityAttendences.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@CrossOrigin
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @GetMapping
    public ResponseEntity<List<AttendancesResponseDTO>> getAttendances
            (@RequestParam String studentId, @RequestParam int semester) {
        return ResponseEntity.ok(attendanceService.getAttendances(studentId, semester));
    }

}
