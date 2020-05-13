package com.UniversityAttendences.service;
import com.UniversityAttendences.entity.Professor;
import com.UniversityAttendences.entity.Student;
import com.UniversityAttendences.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ServiceRepository serviceRepository;

    public Professor getProfessorById(String id) throws Exception{
        return serviceRepository.getProfessorRepository().findById(id).orElseThrow(()-> new Exception("Professor not found"));
    }

    public List<Professor> getAllProfessors(){
        return serviceRepository.getProfessorRepository().findAll();
    }

    public void deleteProfessorById(String id) throws Exception{
        Professor professor = getProfessorById(id);
        serviceRepository.getProfessorRepository().deleteById(professor.getId());
    }
}
