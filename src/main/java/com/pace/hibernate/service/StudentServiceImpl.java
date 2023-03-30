package com.pace.hibernate.service;

import com.pace.hibernate.model.Student;
import com.pace.hibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student> saveAllStudents(List<Student> students){
        return studentRepository.saveAll(students);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }

    public Student getStudentByName(String name){
        Student student = studentRepository.findByName(name);
        return student;
    }

    public Student deleteStudent(int id){
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
        return student;
    }
    public Student updateStudent(int id,Student student){
        Student excistingStudent = studentRepository.findById(id).get();
        if(excistingStudent!=null){
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }
}
