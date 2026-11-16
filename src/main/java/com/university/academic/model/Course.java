package com.university.academic.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity @Table(name = "courses")
@Getter @Setter @NoArgsConstructor
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String title;

    private Integer credits;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "courses")
    private Set<Lecturer> lecturers = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private List<Registration> registrations = new ArrayList<>();
}