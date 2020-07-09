package com.UniversityAttendences.service;

import com.UniversityAttendences.dto.AttendanceResponseDTO;
import com.UniversityAttendences.dto.UpdateAttendanceRequestDTO;
import com.UniversityAttendences.entity.Attendance;
import com.UniversityAttendences.entity.Student;
import com.UniversityAttendences.exception.customException.AttendanceNotFound;
import com.UniversityAttendences.exception.customException.StudentNotFound;
import com.UniversityAttendences.repository.ServiceRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    public static final String ATTENDANCE_NOT_FOUND = "The attendance that you are searching for is not found";

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<AttendanceResponseDTO> getAttendances (String studentId, int semester) throws StudentNotFound {
        Student student = serviceRepository.getStudentRepository().findById(studentId).
                orElseThrow(()-> new StudentNotFound(StudentService.STUDENT_NOT_FOUND));

        List<Attendance> attendances = serviceRepository.getAttendanceRepository().
                findAllByStudentIdAndSemester(student.getId(), semester);

        List<AttendanceResponseDTO> attendanceResponseDTOS = attendances.stream()
            .map(attendance -> {
                AttendanceResponseDTO attendanceResponseDTO = modelMapper
                        .map(attendance, AttendanceResponseDTO.class);
                attendanceResponseDTO.setAttendances(buildAttendancesMap(attendance.getCountOfAttendances()));
                attendanceResponseDTO.setHidden(true);
                return attendanceResponseDTO;
            })
            .collect(Collectors.toList());

        return attendanceResponseDTOS;
    }

    public AttendanceResponseDTO getAttendancesBySubject (String studentId, int semester, String subjectId)
            throws StudentNotFound {
        Student student = serviceRepository.getStudentRepository().findById(studentId).
                orElseThrow(()-> new StudentNotFound(StudentService.STUDENT_NOT_FOUND));

        Attendance attendance = serviceRepository.getAttendanceRepository().
                findByStudentIdAndSemesterAndSubjectId(student.getId(), semester, subjectId);

        AttendanceResponseDTO attendanceResponseDTO = modelMapper.map(attendance, AttendanceResponseDTO.class);
        attendanceResponseDTO.setAttendances(buildAttendancesMap(attendance.getCountOfAttendances()));
        attendanceResponseDTO.setHidden(true);

        return attendanceResponseDTO;
    }

    public AttendanceResponseDTO updateAttendance(@NotNull UpdateAttendanceRequestDTO updateAttendanceDTO){

        Attendance attendance = serviceRepository.getAttendanceRepository()
                .findById(updateAttendanceDTO.getAttendanceId())
                .orElseThrow(()-> new AttendanceNotFound(ATTENDANCE_NOT_FOUND));
        String attendancesCount = buildAttendancesString(updateAttendanceDTO.getAttendances());
        attendance.setCountOfAttendances(attendancesCount);

        Attendance updatedAttendance = serviceRepository.getAttendanceRepository().save(attendance);

        AttendanceResponseDTO attendanceResponseDTO = modelMapper.map(updatedAttendance, AttendanceResponseDTO.class);
        attendanceResponseDTO.setAttendances(buildAttendancesMap(attendance.getCountOfAttendances()));
        attendanceResponseDTO.setHidden(true);

        return attendanceResponseDTO;
    }

    private Map<Integer, Object> buildAttendancesMap(String countOfAttendances){
        Map<Integer, Object> attendances = new TreeMap<>();
        for (int i = 0; i < countOfAttendances.length(); i++) {
            attendances.put((i+1), countOfAttendances.charAt(i) == '0' ? "NO" : "YES");
        }
        return attendances;
    }

    private String buildAttendancesString(Map<Integer, Object> countOfAttendances){
        StringBuilder attendances = new StringBuilder();

        for(Map.Entry<Integer, Object> entry: countOfAttendances.entrySet()){
            attendances.append(entry.getValue().equals("NO") ? '0' : '1');
        }

        return attendances.toString();
    }

}
