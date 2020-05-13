package com.UniversityAttendences.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "total_exercises", nullable = false)
    @NonNull
    private Integer exercises;

    @OneToMany(mappedBy = "subject", cascade = {CascadeType.ALL})
    private List<Program> programs;

    @OneToMany(mappedBy = "subject", cascade = {CascadeType.ALL})
    private List<Attendance> attendances;
}
