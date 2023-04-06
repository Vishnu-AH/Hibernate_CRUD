package com.pace.hibernate.controller;

import com.pace.hibernate.responses.ApiSuccessResponse;
import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.model.School;
import com.pace.hibernate.serviceImplementation.SchoolServiceImplementation;
import com.pace.hibernate.utility.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolServiceImplementation schoolServiceImplementation;
    @PostMapping()
    public ResponseEntity<Object> saveSchool(@RequestBody School school){
        schoolServiceImplementation.saveSchool(school);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.CREATED));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchSchoolById(@PathVariable int id) throws SchoolNotFoundException{
        School school = schoolServiceImplementation.fetchSchoolById(id);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,school));
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<Object> fetchAllSchools(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                  @RequestParam(value = "size", required = false, defaultValue = Integer.MAX_VALUE + "") Integer size,
                                                  @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
                                                  @RequestParam(value = "order", required = false, defaultValue = "DESCENDING") String order) throws SchoolNotFoundException {
        Page<School> schools = schoolServiceImplementation.fetchAllSchools(page,size,sort,order);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,schools));
    }

    @GetMapping("fetchSchoolByName/{name}")
    public ResponseEntity<Object> fetchSchoolByName(@PathVariable String name) throws SchoolNotFoundException{
        School school = schoolServiceImplementation.fetchSchoolByName(name);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,school));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSchool(@PathVariable int id) throws SchoolNotFoundException{
        schoolServiceImplementation.deleteSchool(id);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSchool(@RequestBody School school,@PathVariable int id) throws SchoolNotFoundException {
        schoolServiceImplementation.updateSchool(school,id);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK));
    }
}
