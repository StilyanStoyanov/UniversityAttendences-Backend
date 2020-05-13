package com.UniversityAttendences.dto;

import com.UniversityAttendences.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponseDTO {

    private String id;
    private String fullName;
    private String email;
    private Role role;
    private String facultyNumber;
    private String specialtyName;
    private String specialtyFacultyName;
    private Integer semester;
    private Integer stream;
    private Integer group;

}
