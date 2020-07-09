package com.UniversityAttendences.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateAttendanceRequestDTO {

    private String studentId;

    private String attendanceId;

    private String subjectId;

    private int semester;

    private Map<Integer, Object> attendances;

}
