package com.UniversityAttendences.service;

import com.UniversityAttendences.dto.AttendancesResponseDTO;
import com.UniversityAttendences.dto.StudentsResponseDTO;
import com.UniversityAttendences.entity.Attendance;
import com.UniversityAttendences.entity.Student;
import com.UniversityAttendences.exception.customException.StudentNotFound;
import com.UniversityAttendences.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<AttendancesResponseDTO> getAttendances (String studentId, int semester) throws StudentNotFound {
        Student student = serviceRepository.getStudentRepository().findById(studentId).
                orElseThrow(()-> new StudentNotFound(StudentService.STUDENT_NOT_FOUND));

        List<Attendance> attendances = serviceRepository.getAttendanceRepository().
                findAllByStudentIdAndSemester(student.getId(), semester);

        List<AttendancesResponseDTO> attendancesResponseDTO = attendances.stream()
                        .map(attendance -> modelMapper.map(attendance, AttendancesResponseDTO.class))
                        .collect(Collectors.toList());

        return attendancesResponseDTO;
    }

}
