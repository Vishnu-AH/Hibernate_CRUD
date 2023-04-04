package com.pace.hibernate.controller;

import com.pace.hibernate.ApiSuccess;
import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.model.School;
import com.pace.hibernate.serviceImplementation.SchoolServiceImplementation;
import com.pace.hibernate.utility.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolServiceImplementation schoolServiceImplementation;
    @PostMapping()
    public ResponseEntity<Object> saveSchool(@RequestBody School school){
        schoolServiceImplementation.saveSchool(school);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.CREATED));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchSchoolById(@PathVariable int id) throws SchoolNotFoundException{
        School school = schoolServiceImplementation.fetchSchoolById(id);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK,school));
    }
    @GetMapping()
    public ResponseEntity<Object> fetchAllSchools() throws SchoolNotFoundException{
        List<School> schools = schoolServiceImplementation.fetchAllSchools();
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK,schools));
    }
    @GetMapping("fetchSchoolByName/{name}")
    public ResponseEntity<Object> fetchSchoolByName(@PathVariable String name) throws SchoolNotFoundException{
        School school = schoolServiceImplementation.fetchSchoolByName(name);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK,school));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSchool(@PathVariable int id) throws SchoolNotFoundException{
        schoolServiceImplementation.deleteSchool(id);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSchool(@RequestBody School school,@PathVariable int id) throws SchoolNotFoundException {
        schoolServiceImplementation.updateSchool(school,id);
        return CommonUtil.buildResponse(new ApiSuccess(HttpStatus.OK));
    }
}
