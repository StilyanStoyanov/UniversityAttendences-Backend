package com.UniversityAttendences.service;
import com.UniversityAttendences.dto.SubjectResponseDTO;
import com.UniversityAttendences.entity.Subject;
import com.UniversityAttendences.exception.customException.StudentNotFound;
import com.UniversityAttendences.exception.customException.SubjectNotFound;
import com.UniversityAttendences.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    public static final String SUBJECT_NOT_FOUND = "The subject you are looking for is not exist";
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ModelMapper modelMapper;

    public SubjectResponseDTO getSubjectById(String id) throws StudentNotFound{
        Subject subject = serviceRepository.getSubjectRepository().findById(id).orElseThrow(
                ()-> new SubjectNotFound(SUBJECT_NOT_FOUND));
        return modelMapper.map(subject, SubjectResponseDTO.class);
    }
}
