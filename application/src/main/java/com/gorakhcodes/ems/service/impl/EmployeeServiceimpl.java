package com.gorakhcodes.ems.service.impl;

import com.gorakhcodes.ems.dto.EmployeeDTO;
import com.gorakhcodes.ems.entity.Employee;
import com.gorakhcodes.ems.exception.ResourceNotFoundException;
import com.gorakhcodes.ems.mapper.EmployeeMapper;
import com.gorakhcodes.ems.repository.EmployeeRepository;
import com.gorakhcodes.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO savedEmployeeDTO = EmployeeMapper.mapToEmployeeDTO(savedEmployee);
        return savedEmployeeDTO;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for ID: " + employeeId));

        EmployeeDTO employeeDTO = EmployeeMapper.mapToEmployeeDTO(employee);

        return employeeDTO;
    }
}
