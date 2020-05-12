package com.UniversityAttendences.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceRepository {

    @Autowired
    IStudentRepository userRepository;

    public IStudentRepository getUserRepository() {
        return userRepository;
    }

}
