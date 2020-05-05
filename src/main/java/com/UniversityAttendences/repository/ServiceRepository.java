package com.UniversityAttendences.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceRepository {

    @Autowired
    IUserRepository userRepository;

    public IUserRepository getUserRepository() {
        return userRepository;
    }

}
