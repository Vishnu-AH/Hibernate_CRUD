package com.pace.hibernate.controller;

import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.model.Student;
import com.pace.hibernate.response.Response;
import com.pace.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent/{school_id}")
    public ResponseEntity<Response<Student>> saveStudent(@RequestBody Student student, @PathVariable int school_id) throws SchoolNotFoundException {
            return studentService.saveStudent(student,school_id);
    }

    @PostMapping("/addListOfStudents/{school_id}")
    public ResponseEntity<Response<List<Student>>> saveAllStudents(@RequestBody List<Student> students,@PathVariable int school_id) {
        return studentService.saveAllStudents(students,school_id);
    }

    @GetMapping("/fetchAllStudents")
    public ResponseEntity<Response<List<Student>>> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("fetchStudentById/{id}")
    public ResponseEntity<Response<Student>> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/fetchStudentByName/{name}")
    public ResponseEntity<Response<Student>> getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Response<Student>> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Response<Student>> deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}
