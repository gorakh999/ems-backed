package com.gorakhcodes.ems.service.impl;

import com.gorakhcodes.ems.dto.EmployeeDTO;
import com.gorakhcodes.ems.entity.Employee;
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
}
