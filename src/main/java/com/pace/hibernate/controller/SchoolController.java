package com.pace.hibernate.controller;

import com.pace.hibernate.model.School;
import com.pace.hibernate.response.Response;
import com.pace.hibernate.serviceImplementation.SchoolServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolServiceImplementation schoolServiceImplementation;
    @PostMapping("/addSchool")
    public ResponseEntity<Response<School>> saveSchool(@RequestBody School school){
        return schoolServiceImplementation.saveSchool(school);
    }
    @GetMapping("/fetchSchoolById/{id}")
    public ResponseEntity<Response<School>> fetchSchoolById(@PathVariable int id){
        return schoolServiceImplementation.fetchSchoolById(id);
    }
    @GetMapping("/fetchListOfSchools")
    public ResponseEntity<Response<List<School>>> fetchAllSchools(){
        return schoolServiceImplementation.fetchAllSchools();
    }
    @GetMapping("/fetchSchoolByName/{name}")
    public ResponseEntity<Response<School>> fetchSchoolByName(@PathVariable String name){
        return schoolServiceImplementation.fetchSchoolByName(name);
    }
    @DeleteMapping("/deleteSchool/{id}")
    public ResponseEntity<Response<School>> deleteSchool(@PathVariable int id){
        return schoolServiceImplementation.deleteSchool(id);
    }
    @PutMapping("/updateSchool")
    public ResponseEntity<Response<School>> updateSchool(@RequestBody School school){
        return schoolServiceImplementation.updateSchool(school);
    }
}
