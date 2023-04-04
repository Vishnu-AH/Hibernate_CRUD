package com.pace.hibernate.controller;

import com.pace.hibernate.ApiSuccess;
import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.Exception.StudentNotFoundException;
import com.pace.hibernate.model.Student;
import com.pace.hibernate.service.StudentService;
import com.pace.hibernate.utility.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/{school_id}")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student, @PathVariable int school_id) throws SchoolNotFoundException {
        studentService.saveStudent(student,school_id);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.CREATED));
    }

    @GetMapping()
    public ResponseEntity<Object> getStudents() throws StudentNotFoundException{
        List<Student> students = studentService.getStudents();
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK,students));
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id) throws StudentNotFoundException {
        Student student = studentService.getStudentById(id);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK,student));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getStudentByName(@PathVariable String name) {
        Student student = studentService.getStudentByName(name);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK,student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student,@PathVariable int id) {
        studentService.updateStudent(student,id);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK));
    }
    @GetMapping("/jpql/{id}/{name}")
    public ResponseEntity<Object> getStudentByIdAndName(@PathVariable int id,@PathVariable String name){
        Optional<Student> student = studentService.findStudentByIdAndName(id, name);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK,student));
    }
    @GetMapping("/native/{id}/{name}")
    public ResponseEntity<Object> getByIdAndName(@PathVariable int id,@PathVariable String name){
        Optional<Student> student = studentService.findByIdAndName(id,name);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK,student));
    }
}
