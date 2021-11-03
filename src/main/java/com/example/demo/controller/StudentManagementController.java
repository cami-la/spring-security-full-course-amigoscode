package com.example.demo.controller;

import com.example.demo.student.model.Student;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
@Data
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1l, "James Bond"),
            new Student(2l, "Maria Jones"),
            new Student(3l, "Anna Smith")
    );

//    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

    @GetMapping
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return STUDENTS;
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('student:write'))")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
//    @PreAuthorize("hasAuthority('student:write'))")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
//    @PreAuthorize("hasAuthority('student:write'))")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", studentId, student));
    }
}
