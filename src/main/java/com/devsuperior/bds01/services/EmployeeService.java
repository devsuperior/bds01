package com.devsuperior.bds01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAll(Pageable pageable ) {
		Page<Employee> pageEmployee = employeeRepository.findAll(pageable);
		
		Page<EmployeeDTO> pageEmployeeDto = pageEmployee.map(x -> new EmployeeDTO(x));
		
		return pageEmployeeDto;
		
	}
	
	public EmployeeDTO insert(EmployeeDTO employee) {
		
		Employee newEmployee = new Employee();
		
		newEmployee.setName(employee.getName());
		newEmployee.setEmail(employee.getEmail());
		newEmployee.setDepartment(new Department(employee.getDepartmentId(), "Desenvolvimento"));
		
		newEmployee = employeeRepository.save(newEmployee);
		
		return new EmployeeDTO(newEmployee);
	}
	
}
