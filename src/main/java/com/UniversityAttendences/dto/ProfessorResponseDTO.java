package com.UniversityAttendences.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfessorResponseDTO {

    private String id;

    private String fullName;

    private String email;

    private String phoneNumber;

    private Integer cabinet;

    private String specialty;

}
