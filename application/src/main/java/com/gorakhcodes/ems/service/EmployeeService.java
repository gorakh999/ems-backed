package com.gorakhcodes.ems.service;

import com.gorakhcodes.ems.dto.EmployeeDTO;
import com.gorakhcodes.ems.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployeeDto);

    void deleteEmployee(Long employeeId);
}
