package com.gorakhcodes.ems.repository;

import com.gorakhcodes.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
