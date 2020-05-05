package com.UniversityAttendences.entity;

import com.UniversityAttendences.entity.enums.Role;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "university_system")
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "first_name", nullable = false)
    @NonNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NonNull
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private Role role;

    @Column(name = "user_name", nullable = false, unique = true)
    @NonNull
    private String userName;

    @Column(nullable = false)
    @NonNull
    private String password;

    @Column(nullable = false, unique = true)
    @NonNull
    private String email;

}
