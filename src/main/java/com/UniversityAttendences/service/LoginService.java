package com.UniversityAttendences.service;

import com.UniversityAttendences.dto.LoginResponseDTO;
import com.UniversityAttendences.entity.IUser;
import com.UniversityAttendences.exception.customException.UnauthorizedException;
import com.UniversityAttendences.repository.IProfessorRepository;
import com.UniversityAttendences.repository.IStudentRepository;
import com.UniversityAttendences.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    IStudentRepository studentRepository;

    @Autowired
    IProfessorRepository professorRepository;

    @Autowired
    ModelMapper modelMapper;

    public LoginResponseDTO login(String username, String password){
        IUser user = studentRepository.
                findByFacultyNumberAndEgn(username, password).orElse(null);
        if(user == null){
            user = serviceRepository.getProfessorRepository().
                    findByEmailAndPassword(username, password).orElse(null);
            if(user == null){
                throw new UnauthorizedException("Invalid credentials. Please try again or write to support service");
            }
        }

        return modelMapper.map(user, LoginResponseDTO.class);
    }
}
