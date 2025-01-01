package com.gorakhcodes.ems.mapper;

import com.gorakhcodes.ems.dto.DepartmentDTO;
import com.gorakhcodes.ems.entity.Department;

public class DepartmentMapper {

    public static DepartmentDTO mapToDepartmentDTO(Department department){
        return new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }
    public static Department mapToDepartment(DepartmentDTO departmentDTO){
        return new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription()
        );
    }
}
