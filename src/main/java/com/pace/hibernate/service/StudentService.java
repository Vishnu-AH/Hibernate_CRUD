package com.pace.hibernate.service;

import com.pace.hibernate.model.Student;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public List<Student> saveAllStudents(List<Student> students);

    public List<Student> getStudents();

    public Student getStudentById(int id);

    public Student getStudentByName(String name);

    public Student deleteStudent(int id);

    public Student updateStudent(int id,Student student);
}
