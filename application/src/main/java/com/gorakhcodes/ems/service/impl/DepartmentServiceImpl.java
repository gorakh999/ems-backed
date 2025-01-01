package com.gorakhcodes.ems.service.impl;

import com.gorakhcodes.ems.dto.DepartmentDTO;
import com.gorakhcodes.ems.entity.Department;
import com.gorakhcodes.ems.exception.ResourceNotFoundException;
import com.gorakhcodes.ems.mapper.DepartmentMapper;
import com.gorakhcodes.ems.repository.DepartmentRepository;
import com.gorakhcodes.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {

        Department department = DepartmentMapper.mapToDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDTO savedDepartmentDTO = DepartmentMapper.mapToDepartmentDTO(savedDepartment);

        return savedDepartmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for ID: " + departmentId));

        DepartmentDTO departmentDTO = DepartmentMapper.mapToDepartmentDTO(department);

        return departmentDTO;
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO updatedDepartmentDto) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for ID: " + departmentId));

        Department toUpdateDepartment = DepartmentMapper.mapToDepartment(updatedDepartmentDto);
        toUpdateDepartment.setId(department.getId());

        Department updatedDepartment = departmentRepository.save(toUpdateDepartment);
        return DepartmentMapper.mapToDepartmentDTO(updatedDepartment);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentDTO> departmentsDTOList = new ArrayList<>();

        for(Department dept: departmentList){
            departmentsDTOList.add(DepartmentMapper.mapToDepartmentDTO(dept));
        }
        return departmentsDTOList;
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for ID: " + departmentId));

        departmentRepository.delete(department);
    }
}
