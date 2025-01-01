package com.gorakhcodes.ems.controller;

import com.gorakhcodes.ems.dto.DepartmentDTO;
import com.gorakhcodes.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    // Add Department
    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartment = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // Get Department By ID
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDTO savedDepartment = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }

    // Get All Departments
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departmentsList = departmentService.getAllDepartments();
        return new ResponseEntity<>(departmentsList, HttpStatus.OK);
    }

    // Update Department By ID
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDTO updatedDepartmentDto){
        DepartmentDTO departmentDTO = departmentService.updateDepartment(departmentId, updatedDepartmentDto);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    // Delete Department By ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("Department Deleted Successfully.", HttpStatus.OK);
    }
}
