package com.gorakhcodes.ems.controller;

import com.gorakhcodes.ems.dto.EmployeeDTO;
import com.gorakhcodes.ems.exception.ResourceNotFoundException;
import com.gorakhcodes.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Employee Management System";
    }

    // Add Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get Employee By ID
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO savedEmployee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employeesList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeesList, HttpStatus.OK);
    }

    // Update Employee By ID
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDTO updatedEmployeeDto){
        EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployeeDto);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    // Delete Employee By ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee Deleted Successfully.", HttpStatus.OK);
    }
}
