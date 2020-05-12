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
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @OneToMany(mappedBy="specialty",
                cascade = CascadeType.ALL)
    private Set<Student> students;

    @ManyToOne
    @NonNull
    @JoinColumn(name="faculty_id", nullable=false)
    private Faculty faculty;


    @OneToMany(mappedBy = "specialty", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Program> programs;
}
