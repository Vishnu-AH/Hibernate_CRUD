package com.pace.hibernate.service;

import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.model.Student;
import com.pace.hibernate.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    public ResponseEntity<Response<Student>> saveStudent(Student student, int school_id) throws SchoolNotFoundException;

    public ResponseEntity<Response<List<Student>>> saveAllStudents(List<Student> students,int school_id);

    public ResponseEntity<Response<List<Student>>> getStudents();

    public ResponseEntity<Response<Student>> getStudentById(int id);

    public ResponseEntity<Response<Student>> getStudentByName(String name);

    public ResponseEntity<Response<Student>> deleteStudent(int id);

    public ResponseEntity<Response<Student>> updateStudent(Student student);
}
