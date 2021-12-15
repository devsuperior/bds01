package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;

import java.io.Serializable;

public class DepartmentDTO implements Serializable {

    public Long id;
    public String name;
//    public List<Employee> employees = new ArrayList<>();

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Department department) {
        id = department.getId();
        name = department.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
