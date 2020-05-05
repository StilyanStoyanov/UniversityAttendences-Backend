package com.UniversityAttendences.controller;

import com.UniversityAttendences.entity.User;
import com.UniversityAttendences.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> gerUserById (@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<User> getAllUsers (@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById (@PathVariable("id") String id) throws Exception {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

}
