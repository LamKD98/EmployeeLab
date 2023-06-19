package com.codeclan.employeeService.repositories;


import com.codeclan.employeeService.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "duration")
    private int duration;

    @JsonIgnoreProperties({"projects"})
    @ManyToMany
    @JoinTable(
            name = "employees_projects",
            joinColumns = {@JoinColumn(
                    name = "project_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "employee_id",
                    nullable = false,
                    updatable = false
            )}
    )
    private List<Employee> employees;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Project(String projectName, int duration) {
        this.projectName = projectName;
        this.duration = duration;
        this.employees = new ArrayList<>();
    }

    public Project(){}

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
