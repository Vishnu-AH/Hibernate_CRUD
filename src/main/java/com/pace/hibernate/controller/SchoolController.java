package com.pace.hibernate.controller;

import com.pace.hibernate.responses.ApiSuccessResponse;
import com.pace.hibernate.Exception.SchoolNotFoundException;
import com.pace.hibernate.model.School;
import com.pace.hibernate.serviceImplementation.SchoolServiceImplementation;
import com.pace.hibernate.utility.CommonUtil;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
@SecurityRequirement(name = "javainuseapi")
public class SchoolController {
    @Autowired
    private SchoolServiceImplementation schoolServiceImplementation;

    Logger logger = LoggerFactory.getLogger(SchoolController.class);
    @PostMapping()
    public ResponseEntity<Object> saveSchool(@RequestBody School school){
        schoolServiceImplementation.saveSchool(school);
        logger.info("Saving the school details...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.CREATED));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchSchoolById(@PathVariable int id) throws SchoolNotFoundException{
        School school = schoolServiceImplementation.fetchSchoolById(id);
        logger.info("Fetching school details with given ID...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,school));
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<Object> fetchAllSchools(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                  @RequestParam(value = "size", required = false, defaultValue = Integer.MAX_VALUE + "") Integer size,
                                                  @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
                                                  @RequestParam(value = "order", required = false, defaultValue = "DESCENDING") String order) throws SchoolNotFoundException {
        Page<School> schools = schoolServiceImplementation.fetchAllSchools(page,size,sort,order);
        logger.info("Fetching all schools available in the database...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,schools));
    }

    @GetMapping("fetchSchoolByName/{name}")
    public ResponseEntity<Object> fetchSchoolByName(@PathVariable String name) throws SchoolNotFoundException{
        School school = schoolServiceImplementation.fetchSchoolByName(name);
        logger.info("Fetching the school with given name...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,school));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSchool(@PathVariable int id) throws SchoolNotFoundException{
        schoolServiceImplementation.deleteSchool(id);
        logger.info("Deleting the school with given ID...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSchool(@RequestBody School school,@PathVariable int id) throws SchoolNotFoundException {
        schoolServiceImplementation.updateSchool(school,id);
        logger.info("Updating the school with given details...");
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK));
    }
}
