package com.UniversityAttendences.service;

import com.UniversityAttendences.dto.SpecialtyDTO;
import com.UniversityAttendences.entity.Specialty;
import com.UniversityAttendences.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtyService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<SpecialtyDTO> getAllSpecialties(){
        List<Specialty> specialties = serviceRepository.getSpecialtyRepository().findAll();
        return specialties.stream().map(student -> modelMapper.map(student, SpecialtyDTO.class)).collect(Collectors.toList());
    }
}
