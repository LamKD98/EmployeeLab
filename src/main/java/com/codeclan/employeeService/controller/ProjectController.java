package com.codeclan.employeeService.controller;

import com.codeclan.employeeService.repositories.Project;
import com.codeclan.employeeService.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping(value = "/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping(value = "/projects/{id}")
    public Optional<Project> getProject(Long id) {
        return projectRepository.findById(id);
    }
}
