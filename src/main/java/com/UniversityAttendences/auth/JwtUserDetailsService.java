package com.UniversityAttendences.auth;

import com.UniversityAttendences.entity.IUser;
import com.UniversityAttendences.repository.ServiceRepository;
import com.UniversityAttendences.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        IUser user = serviceRepository.getStudentRepository().
                findByFacultyNumber(username).orElse(null);
        if(user == null){
            user = serviceRepository.getProfessorRepository().
                    findByEmail(username).orElse(null);
            if(user == null){
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
        }
        return new User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(LoginService.ROLE_PREFIX + user.getRole().name())));
    }
}