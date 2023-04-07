package com.pace.hibernate.controller;

import com.pace.hibernate.responses.ApiSuccessResponse;
import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.Exception.StudentNotFoundException;
import com.pace.hibernate.model.Student;
import com.pace.hibernate.service.StudentService;
import com.pace.hibernate.utility.CommonUtil;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
@SecurityRequirement(name = "javainuseapi")
public class StudentController {
    @Autowired
    private StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/{school_id}")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student, @PathVariable int school_id) throws SchoolNotFoundException {
        studentService.saveStudent(student,school_id);
        logger.info("saving the student details...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.CREATED));
    }

    @GetMapping("fetchAll")
    public ResponseEntity<Object> getStudents(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                              @RequestParam(value = "size", required = false, defaultValue = Integer.MAX_VALUE + "") Integer size,
                                              @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
                                              @RequestParam(value = "order", required = false, defaultValue = "DESCENDING") String order) throws StudentNotFoundException{
        Page<Student> students = studentService.fetchAllStudents(page,size,sort,order);
        logger.info("Fetching all students available in the database...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,students));
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id) throws StudentNotFoundException {
        try{
            Optional<Student> student = studentService.getStudentById(id);
            logger.info("Fetching student by given ID...");
            return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,student));
        }catch(StudentNotFoundException exception){
            throw new StudentNotFoundException("Student not found for given ID");
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getStudentByName(@PathVariable String name) throws StudentNotFoundException{
        try{
            Optional<Student> student = studentService.getStudentByName(name);
            logger.info("Fetching student for given name...");
            return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,student));
        }
        catch(StudentNotFoundException exception){
            throw new StudentNotFoundException("Student not found for given ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student,@PathVariable int id) throws StudentNotFoundException{
        studentService.updateStudent(student,id);
        logger.info("Updating the student with given details...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable int id) throws StudentNotFoundException{
        studentService.deleteStudent(id);
        logger.info("Deleting student with the given ID...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK));
    }
    @GetMapping("/jpql/{id}/{name}")
    public ResponseEntity<Object> getStudentByIdAndName(@PathVariable int id,@PathVariable String name)throws StudentNotFoundException{
        Optional<Student> student = studentService.findStudentByIdAndName(id, name);
        logger.info("Fetching student with the given ID and Name...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,student));
    }
    @GetMapping("/native/{id}/{name}")
    public ResponseEntity<Object> getByIdAndName(@PathVariable int id,@PathVariable String name)throws StudentNotFoundException{
        Optional<Student> student = studentService.findByIdAndName(id,name);
        logger.info("Fetching student with the given ID and Name...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,student));
    }
}
