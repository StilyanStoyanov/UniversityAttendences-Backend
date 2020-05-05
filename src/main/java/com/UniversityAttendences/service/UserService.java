package com.UniversityAttendences.service;

import com.UniversityAttendences.entity.User;
import com.UniversityAttendences.repository.IUserRepository;
import com.UniversityAttendences.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    ServiceRepository serviceRepository;

    public User getUserById(String id) throws Exception{
        return serviceRepository.getUserRepository().findById(id).orElseThrow(()-> new Exception("User not found"));
    }

    public List<User> getAllUsers(){
        return serviceRepository.getUserRepository().findAll();
    }


    public void deleteUserById(String id) throws Exception{
        User user = getUserById(id);
        serviceRepository.getUserRepository().deleteById(user.getId());
    }

}
