package com.university.academic.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity @Table(name = "lecturers")
@Getter @Setter @NoArgsConstructor
public class Lecturer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Many-to-many with join table (no entity)
    @ManyToMany
    @JoinTable(
        name = "lecturer_courses",
        joinColumns = @JoinColumn(name = "lecturer_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();
}