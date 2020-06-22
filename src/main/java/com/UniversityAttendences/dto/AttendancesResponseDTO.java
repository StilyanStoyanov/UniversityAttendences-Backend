package com.UniversityAttendences.dto;

import com.UniversityAttendences.entity.Student;
import com.UniversityAttendences.entity.Subject;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttendancesResponseDTO {

    private String id;

    private String countOfAttendances;

    private int semester;

    private String studentName;

    private String subjectName;
}
