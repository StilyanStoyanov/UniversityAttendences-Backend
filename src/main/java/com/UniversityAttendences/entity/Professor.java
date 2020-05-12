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
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "fullName", nullable = false)
    @NonNull
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(name = "password", nullable = false)
    @NonNull
    private String password;

    @Column(name = "phoneNumber")
    @NonNull
    private String phoneNumber;

    @Column(name = "cabinet")
    @NonNull
    private Integer cabinet;

    @OneToMany(mappedBy = "professor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Program> programs;
}
