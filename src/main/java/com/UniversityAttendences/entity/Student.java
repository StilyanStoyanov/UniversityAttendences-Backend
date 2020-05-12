package com.UniversityAttendences.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "fullName", nullable = false)
    @NonNull
    private String fullName;

    @ManyToOne
    @NonNull
    @JoinColumn(name="specialty_id", nullable = false)
    private Specialty specialty;

    @Column(name = "facultyNumber", nullable = false, unique = true)
    @NonNull
    private String facultyNumber;

    @Column(name = "egn", nullable = false, unique = true)
    @NonNull
    private String egn;

    @Column(name = "email", nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(name = "stream", nullable = false)
    @NonNull
    private int stream;

    @Column(name = "studentGroup", nullable = false)
    @NonNull
    private int studentGroup;

    @Column(name = "semester", nullable = false)
    @NonNull
    private int semester;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Attendance> attendances;
}
