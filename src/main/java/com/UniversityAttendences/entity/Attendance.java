package com.UniversityAttendences.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendances")
public class Attendance {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "countOfAttendances", nullable = false)
    @NonNull
    private String countOfAttendances;

    @Column(name = "semester", nullable = false)
    @NonNull
    private Integer semester;

}
