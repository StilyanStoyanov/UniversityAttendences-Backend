package com.UniversityAttendences.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendances", uniqueConstraints = { @UniqueConstraint(columnNames = {"student_id", "subject_id"})})
public class Attendance {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @NonNull
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    @NonNull
    private Subject subject;

    @Column(name = "countOfAttendances", nullable = false)
    @NonNull
    private String countOfAttendances;

    @Column(name = "semester", nullable = false)
    @NonNull
    private Integer semester;

}
