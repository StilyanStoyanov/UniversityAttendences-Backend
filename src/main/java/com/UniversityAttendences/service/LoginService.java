package com.UniversityAttendences.service;

import com.UniversityAttendences.auth.JwtTokenUtil;
import com.UniversityAttendences.dto.LoginResponseDTO;
import com.UniversityAttendences.entity.IUser;
import com.UniversityAttendences.exception.customException.UnauthorizedException;
import com.UniversityAttendences.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LoginService {

    public static final String ROLE_PREFIX = "ROLE_";

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    JwtTokenUtil tokenUtil;

    @Autowired
    ModelMapper modelMapper;

    public LoginResponseDTO login(String username, String password){
        IUser user = serviceRepository.getStudentRepository().
                findByFacultyNumberAndEgn(username, password).orElse(null);
        if(user == null){
            user = serviceRepository.getProfessorRepository().
                    findByEmailAndPassword(username, password).orElse(null);
            if(user == null){
                throw new UnauthorizedException("Invalid credentials. Please try again or write to support service");
            }
        }

        final UserDetails userDetails = new User(username, password,
                Collections.singletonList(new SimpleGrantedAuthority(ROLE_PREFIX + user.getRole().name())));

        LoginResponseDTO response = modelMapper.map(user, LoginResponseDTO.class);
        response.setToken(tokenUtil.generateToken(userDetails));

        return response;
    }
}
