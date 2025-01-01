package com.gorakhcodes.ems.repository;

import com.gorakhcodes.ems.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
