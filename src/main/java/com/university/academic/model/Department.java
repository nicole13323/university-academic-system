package com.university.academic.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity @Table(name = "departments")
@Getter @Setter @NoArgsConstructor
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    // Department head: one-to-one, FK lives here
    @OneToOne
    @JoinColumn(name = "head_id", unique = true)
    private Lecturer head;

    @OneToMany(mappedBy = "department")
    private List<Lecturer> lecturers = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Course> courses = new ArrayList<>();
}