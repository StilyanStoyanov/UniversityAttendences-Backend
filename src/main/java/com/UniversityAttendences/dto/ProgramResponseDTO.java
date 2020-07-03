package com.UniversityAttendences.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgramResponseDTO {

    private String id;

    private String professorFullName;

    private String specialtyName;

    private String specialtyId;

    private String subjectName;

    private int semester;

}
