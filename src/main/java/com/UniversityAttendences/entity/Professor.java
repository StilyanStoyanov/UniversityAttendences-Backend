package com.UniversityAttendences.entity;

import com.UniversityAttendences.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professors")
public class Professor implements IUser {
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

    @OneToMany(mappedBy = "professor", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Program> programs;

    @Override
    public Role getRole() {
        return Role.PROFESSOR;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
