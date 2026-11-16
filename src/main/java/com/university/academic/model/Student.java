package com.university.academic.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity @Table(name = "students")
@Getter @Setter @NoArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String registrationNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile profile;

    @OneToMany(mappedBy = "student")
    private List<Registration> registrations = new ArrayList<>();
}