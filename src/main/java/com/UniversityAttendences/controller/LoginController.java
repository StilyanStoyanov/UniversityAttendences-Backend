package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.LoginRequestDTO;
import com.UniversityAttendences.dto.LoginResponseDTO;
import com.UniversityAttendences.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(loginService.login(request.getUsername(), request.getPassword()));
    }

}
