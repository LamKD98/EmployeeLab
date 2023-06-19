package com.codeclan.employeeService;

import com.codeclan.employeeService.repositories.DepartmentRepository;
import com.codeclan.employeeService.repositories.EmployeeRepository;
import com.codeclan.employeeService.repositories.Project;
import com.codeclan.employeeService.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateEmployee() {
		Department department = new Department("IT");
		departmentRepository.save(department);
		Employee employee = new Employee("Henry", "Hoover", department);
		employeeRepository.save(employee);
		Project project = new Project("WebApp", 14);
		projectRepository.save(project);
		employee.addProject(project);
		employeeRepository.save(employee);
	}

}
