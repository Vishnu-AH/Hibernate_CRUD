package com.pace.hibernate.controller;

import com.pace.hibernate.model.School;
import com.pace.hibernate.serviceImplementation.SchoolServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolServiceImplementation schoolServiceImplementation;
    @PostMapping("/addSchool")
    public School saveSchool(@RequestBody School school){
        return schoolServiceImplementation.saveSchool(school);
    }
    @GetMapping("/fetchSchoolById/{id}")
    public School fetchSchoolById(@PathVariable int id){
        return schoolServiceImplementation.fetchSchoolById(id);
    }
    @GetMapping("/fetchListOfSchools")
    public List<School> fetchAllSchools(){
        return schoolServiceImplementation.fetchAllSchools();
    }
    @GetMapping("/fetchSchoolByName/{name}")
    public School fetchSchoolByName(@PathVariable String name){
        return schoolServiceImplementation.fetchSchoolByName(name);
    }
    @DeleteMapping("/deleteSchool/{id}")
    public School deleteSchool(@PathVariable int id){
        return schoolServiceImplementation.deleteSchool(id);
    }
    @PutMapping("/updateSchool")
    public School updateSchool(@RequestBody School school){
        return schoolServiceImplementation.updateSchool(school);
    }
}
