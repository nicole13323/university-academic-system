package com.university.academic.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Table(name = "student_profiles")
@Getter @Setter @NoArgsConstructor
public class StudentProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String address;

    @OneToOne(optional = false)
    @JoinColumn(name = "student_id", unique = true)
    private Student student;
}