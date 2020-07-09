package com.UniversityAttendences.service;
import com.UniversityAttendences.dto.ProfessorResponseDTO;
import com.UniversityAttendences.dto.ProgramResponseDTO;
import com.UniversityAttendences.entity.Professor;
import com.UniversityAttendences.entity.Program;
import com.UniversityAttendences.entity.Specialty;
import com.UniversityAttendences.exception.customException.ProfessorNotFound;
import com.UniversityAttendences.exception.customException.ProgramNotFound;
import com.UniversityAttendences.exception.customException.SpecialtyNotFound;
import com.UniversityAttendences.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    public static final String PROFESSOR_NOT_FOUND = "The professor that you are searching for is not part of our system";
    public static final String SPECIALTY_NOT_FOUND = "The specialty that you are searching for is not part of our system";

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ModelMapper modelMapper;

    public ProfessorResponseDTO getProfessorById(String id) throws ProfessorNotFound {
        Professor professor = serviceRepository.getProfessorRepository().findById(id)
                .orElseThrow(()-> new ProfessorNotFound(PROFESSOR_NOT_FOUND));
        return modelMapper.map(professor, ProfessorResponseDTO.class);
    }

    public List<ProfessorResponseDTO> getAllProfessors(){
        List<Professor> professors = serviceRepository.getProfessorRepository().findAllByOrderByFullNameAsc();
        return professors.stream()
                .map(professor -> modelMapper.map(professor, ProfessorResponseDTO.class))
                .collect(Collectors.toList());
    }

    public Set<ProfessorResponseDTO> getAllProfessors(String specialtyId, int semester){
        Specialty specialty = serviceRepository.getSpecialtyRepository()
                .findById(specialtyId).orElseThrow(()-> new SpecialtyNotFound(SPECIALTY_NOT_FOUND));

        List<Program> programs = serviceRepository.getProgramRepository()
                .findAllBySpecialtyIdAndSemester(specialty.getId(), semester);

        Set<ProfessorResponseDTO> professors = programs.stream()
                .map(program -> {
                    ProfessorResponseDTO professorResponseDTO =
                            modelMapper.map(program.getProfessor(), ProfessorResponseDTO.class);
                    professorResponseDTO.setSpecialty(program.getSubject().getName());

                    return professorResponseDTO;
                })
                .collect(Collectors.toSet());

        return professors;
    }

    public void deleteProfessorById(String id) throws ProfessorNotFound{
        ProfessorResponseDTO professor = getProfessorById(id);
        serviceRepository.getProfessorRepository().deleteById(professor.getId());
    }

    public List<ProgramResponseDTO> getProfessorProgramById(String id, String specialtyId, int semester) throws ProfessorNotFound {
        Professor professor = serviceRepository.getProfessorRepository().findById(id)
                .orElseThrow(()-> new ProfessorNotFound(PROFESSOR_NOT_FOUND));

        List<Program> programs;

        if((specialtyId == null || specialtyId.isEmpty()) && semester == 0){
            programs = serviceRepository.getProgramRepository()
                    .findAllByProfessorIdOrderBySemester(id);
        }
        else if((specialtyId == null || specialtyId.isEmpty())&& semester > 0){
            programs = serviceRepository.getProgramRepository()
                    .findAllByProfessorIdAndSemester(id, semester);
        } else if((specialtyId == null || !specialtyId.isEmpty()) && semester == 0){
            programs = serviceRepository.getProgramRepository()
                    .findAllByProfessorIdAndSpecialtyId(id, specialtyId);
        } else {
            programs = serviceRepository.getProgramRepository()
                    .findAllByProfessorIdAndSpecialtyIdAndSemesterOrderBySemester(id,
                            specialtyId, semester);
        }

        if(programs == null || programs.isEmpty()){
            throw new ProgramNotFound("Program not found for professor: " + professor.getFullName());
        }

        List<ProgramResponseDTO> professorProgram = programs.stream()
                .map(program -> {
                    ProgramResponseDTO programResponseDTO =
                            modelMapper.map(program, ProgramResponseDTO.class);
                    return programResponseDTO;
                })
                .collect(Collectors.toList());

        return professorProgram;
    }


}
