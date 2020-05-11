package com.UniversityAttendences.controller;

import com.UniversityAttendences.dto.LoginRequest;
import com.UniversityAttendences.entity.User;
import com.UniversityAttendences.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> gerUserById (@RequestBody LoginRequest request) throws Exception {
        return ResponseEntity.ok(userService.login(request.getUsername(), request.getPassword()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> gerUserById (@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () throws Exception {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById (@PathVariable("id") String id) throws Exception {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

}
