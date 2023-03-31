package com.pace.hibernate.serviceImplementation;

import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.Exception.StudentNotFoundException;
import com.pace.hibernate.model.School;
import com.pace.hibernate.model.Student;
import com.pace.hibernate.repository.SchoolRepository;
import com.pace.hibernate.repository.StudentRepository;
import com.pace.hibernate.response.Response;
import com.pace.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public ResponseEntity<Response<Student>> saveStudent(Student student, int school_id) throws SchoolNotFoundException {
        if(schoolRepository.findById(school_id).isPresent()){
            School school = schoolRepository.findById(school_id).get();
            student.setSchool(school);
            Response<Student> response = new Response<>();
            response.setMessage("successfully saved");
            response.setHttpStatus(HttpStatus.CREATED.value());
            response.setData(studentRepository.save(student));
            return new ResponseEntity<Response<Student>>(response, HttpStatus.CREATED);
        }else{
            throw new SchoolNotFoundException("School does not exist for given ID");
        }
    }
    public ResponseEntity<Response<List<Student>>> saveAllStudents(List<Student> students,int school_id) throws SchoolNotFoundException{
        if(schoolRepository.findById(school_id).isPresent()){
            Response<List<Student>> response = new Response<>();
            School school = schoolRepository.findById(school_id).get();
            for (Student student:students) {
                student.setSchool(school);
            }
            studentRepository.saveAll(students);
            response.setMessage("successfully saved");
            response.setHttpStatus(HttpStatus.CREATED.value());
            response.setData(students);
            return new ResponseEntity<Response<List<Student>>>(response, HttpStatus.CREATED);
        }else{
            throw new SchoolNotFoundException("School does not exist for given ID");
        }
    }

    public ResponseEntity<Response<List<Student>>> getStudents(){
        List<Student> students = studentRepository.findAll();
        Response<List<Student>> response = new Response<>();
        response.setMessage("Found");
        response.setHttpStatus(HttpStatus.FOUND.value());
        response.setData(students);
        return new ResponseEntity<Response<List<Student>>>(response, HttpStatus.FOUND);
    }
    public ResponseEntity<Response<Student>> getStudentById(int id){
        if (studentRepository.findById(id).isPresent()) {
            Response<Student> response = new Response<>();
            response.setMessage("Found");
            response.setHttpStatus(HttpStatus.FOUND.value());
            response.setData(studentRepository.findById(id).get());
            return new ResponseEntity<Response<Student>>(response, HttpStatus.FOUND);
        }else{
            throw new StudentNotFoundException("Student not present for given ID");
        }
    }

    public ResponseEntity<Response<Student>> getStudentByName(String name){
        if (studentRepository.findByName(name)!=null) {
            Response<Student> response = new Response<>();
            response.setMessage("Found");
            response.setHttpStatus(HttpStatus.FOUND.value());
            response.setData(studentRepository.findByName(name));
            return new ResponseEntity<Response<Student>>(response, HttpStatus.FOUND);
        }else{
            throw new StudentNotFoundException("Student not present for given Name");
        }
    }

    public ResponseEntity<Response<Student>> deleteStudent(int id){
        if (studentRepository.findById(id).isPresent()) {
            Response<Student> response = new Response<>();
            Student student = studentRepository.findById(id).get();
            studentRepository.delete(student);
            response.setMessage("Found");
            response.setHttpStatus(HttpStatus.FOUND.value());
            response.setData(student);
            return new ResponseEntity<Response<Student>>(response, HttpStatus.FOUND);
        }else{
            throw new StudentNotFoundException("Student not present for given Name");
        }
    }
    public ResponseEntity<Response<Student>> updateStudent(Student student){
        if(studentRepository.findById(student.getId()).isPresent()){
            Student excistingStudent = studentRepository.findById(student.getId()).get();
            student.setSchool(excistingStudent.getSchool());
            Response<Student> response = new Response<>();
            response.setMessage("Found");
            response.setHttpStatus(HttpStatus.FOUND.value());
            response.setData(studentRepository.save(student));
            return new ResponseEntity<Response<Student>>(response, HttpStatus.FOUND);
        }else{
            throw new StudentNotFoundException("Student does not exists to update");
        }
    }
}
