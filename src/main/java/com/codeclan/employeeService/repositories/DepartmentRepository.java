package com.codeclan.employeeService.repositories;

import com.codeclan.employeeService.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
