package com.UniversityAttendences.service;
import com.UniversityAttendences.dto.ProfessorResponseDTO;
import com.UniversityAttendences.entity.Professor;
import com.UniversityAttendences.exception.customException.ProfessorNotFound;
import com.UniversityAttendences.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    public static final String PROFESSOR_NOT_FOUND = "The professor that you are searching for is not part of the our system";

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ModelMapper modelMapper;


    public ProfessorResponseDTO getProfessorById(String id) throws ProfessorNotFound {
        Professor professor = serviceRepository.getProfessorRepository().findById(id).orElseThrow(()-> new ProfessorNotFound(PROFESSOR_NOT_FOUND));
        return modelMapper.map(professor, ProfessorResponseDTO.class);
    }

    public List<ProfessorResponseDTO> getAllProfessors(){
        List<Professor> professors = serviceRepository.getProfessorRepository().findAll();
        return professors.stream().map(professor -> modelMapper.map(professor, ProfessorResponseDTO.class)).collect(Collectors.toList());
    }

    public void deleteProfessorById(String id) throws ProfessorNotFound{
        ProfessorResponseDTO professor = getProfessorById(id);
        serviceRepository.getProfessorRepository().deleteById(professor.getId());
    }
}
