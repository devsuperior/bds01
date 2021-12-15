package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<EmployeeDTO> findAll(Pageable pageable) {

        Page<Employee> page = employeeRepository.findAll(pageable);
        return page.map(e -> new EmployeeDTO(e));
    }

    public EmployeeDTO insert(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee = employeeRepository.save(DTOToEntity(employeeDTO));
        return new EmployeeDTO(employee);
    }

    public Employee DTOToEntity(EmployeeDTO employeeDTO) {

        Department department = new Department();
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        department.setId(employeeDTO.getDepartmentId());
        employee.setDepartment(department);

        return employee;
    }
}
