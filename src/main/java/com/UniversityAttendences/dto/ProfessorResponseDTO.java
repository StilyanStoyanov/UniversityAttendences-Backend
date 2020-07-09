package com.UniversityAttendences.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public class ProfessorResponseDTO {

    private String id;

    private String fullName;

    private String email;

    private String phoneNumber;

    private Integer cabinet;

    @EqualsAndHashCode.Exclude
    private String specialty;

}
