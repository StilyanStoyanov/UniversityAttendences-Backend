package com.UniversityAttendences.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "programs", uniqueConstraints = { @UniqueConstraint(columnNames = {"professor_id", "subject_id", "specialty_id", "semester"})})
public class Program {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Column(name = "semester", nullable = false)
    @NonNull
    private Integer semester;
}
