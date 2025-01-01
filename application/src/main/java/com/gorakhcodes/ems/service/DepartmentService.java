package com.gorakhcodes.ems.service;

import com.gorakhcodes.ems.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentById(Long departmentId);
    DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO updatedDepartmentDto);
    List<DepartmentDTO> getAllDepartments();
    void deleteDepartment(Long departmentId);
}
