package com.UniversityAttendences.service;

import com.UniversityAttendences.dto.AttendancesResponseDTO;
import com.UniversityAttendences.entity.Attendance;
import com.UniversityAttendences.entity.Student;
import com.UniversityAttendences.exception.customException.StudentNotFound;
import com.UniversityAttendences.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    public static final String EXERCISE = "Упражнение ";
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<AttendancesResponseDTO> getAttendances (String studentId, int semester) throws StudentNotFound {
        Student student = serviceRepository.getStudentRepository().findById(studentId).
                orElseThrow(()-> new StudentNotFound(StudentService.STUDENT_NOT_FOUND));

        List<Attendance> attendances = serviceRepository.getAttendanceRepository().
                findAllByStudentIdAndSemester(student.getId(), semester);

        List<AttendancesResponseDTO> attendancesResponseDTOs = attendances.stream()
            .map(attendance -> {
                AttendancesResponseDTO attendancesResponseDTO = modelMapper
                        .map(attendance, AttendancesResponseDTO.class);
                attendancesResponseDTO.setAttendances(buildAttendancesMap(attendance.getCountOfAttendances()));
                attendancesResponseDTO.setHidden(true);
                return attendancesResponseDTO;
            })
            .collect(Collectors.toList());

        return attendancesResponseDTOs;
    }

    private Map<Integer, Object> buildAttendancesMap(String countOfAttendances){
        Map<Integer, Object> attendances = new TreeMap<>();
        for (int i = 0; i < countOfAttendances.length(); i++) {
            attendances.put((i+1), countOfAttendances.charAt(i) == '0' ? "NO" : "YES");
        }
        return attendances;
    }

}
