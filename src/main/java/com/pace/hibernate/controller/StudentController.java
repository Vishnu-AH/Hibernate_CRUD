package com.pace.hibernate.controller;

import com.pace.hibernate.model.Student;
import com.pace.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping("/students")
    public List<Student> saveAllStudents(@RequestBody List<Student> students) {
        return studentService.saveAllStudents(students);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/studentByName/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/student/{id}")
    public Student deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}
