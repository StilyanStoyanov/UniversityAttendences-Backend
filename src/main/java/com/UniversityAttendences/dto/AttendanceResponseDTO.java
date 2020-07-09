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
public class AttendanceResponseDTO {

    private String id;

    private String countOfAttendances;

    private int semester;

    private String studentName;

    private String subjectName;

    private Map<Integer, Object> attendances;

    private Boolean hidden;
}
