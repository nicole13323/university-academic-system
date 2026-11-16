package com.university.academic;

import com.university.academic.model.*;
import com.university.academic.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final DepartmentRepository depts; private final LecturerRepository lecs;
    private final StudentRepository studs; private final CourseRepository courses;
    private final RegistrationRepository regs;

    public DataLoader(DepartmentRepository d, LecturerRepository l, StudentRepository s,
                      CourseRepository c, RegistrationRepository r) {
        depts = d; lecs = l; studs = s; courses = c; regs = r;
    }

    @Override
    public void run(String... args) {
        if (depts.count() > 0) return;

        Department cs = new Department();
        cs.setName("Computer Science"); cs.setCode("CS");
        cs = depts.save(cs);

        Lecturer lec = new Lecturer();
        lec.setFirstName("Jean"); lec.setLastName("Mugabo");
        lec.setEmail("jean@uni.rw"); lec.setDepartment(cs);
        lec = lecs.save(lec);

        cs.setHead(lec);
        depts.save(cs);

        Course c = new Course();
        c.setCode("CS101"); c.setTitle("Web Technology"); c.setCredits(3); c.setDepartment(cs);
        c = courses.save(c);

        lec.getCourses().add(c);
        lecs.save(lec);

        Student s = new Student();
        s.setFirstName("Aline"); s.setLastName("Uwase");
        s.setEmail("aline@uni.rw"); s.setRegistrationNumber("2026/001"); s.setDepartment(cs);
        StudentProfile p = new StudentProfile();
        p.setDateOfBirth(LocalDate.of(2004, 5, 12)); p.setGender("Female");
        p.setPhoneNumber("0788000000"); p.setAddress("Kigali"); p.setStudent(s);
        s.setProfile(p);
        s = studs.save(s);

        Registration r = new Registration();
        r.setStudent(s); r.setCourse(c);
        r.setRegistrationDate(LocalDate.now());
        r.setAcademicYear("2026/2027"); r.setSemester("Semester 1");
        r.setStatus(RegistrationStatus.APPROVED); r.setGrade(85.0);
        regs.save(r);
    }
}