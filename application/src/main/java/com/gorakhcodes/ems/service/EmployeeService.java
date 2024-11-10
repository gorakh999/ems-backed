package com.gorakhcodes.ems.service;

import com.gorakhcodes.ems.dto.EmployeeDTO;
import com.gorakhcodes.ems.exception.ResourceNotFoundException;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long employeeId);
}
