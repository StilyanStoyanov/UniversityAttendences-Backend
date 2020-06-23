package com.UniversityAttendences.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentsResponseDTO {

    private String id;

    private String fullName;

    private String specialtyName;

    private String specialtyId;

    private String facultyNumber;

    private String egn;

    private String email;

    private int stream;

    private int studentGroup;

    private int semester;
}
