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
	private EmployeeRepository repository;

	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAll(Pageable pageable) {
		Page<Employee> employees = repository.findAll(pageable);
		return employees.map(EmployeeDTO::new);
	}
	

	@Transactional
	public EmployeeDTO insert(EmployeeDTO employeeDTO) {

		Employee employee = new Employee();
		employee.setEmail(employeeDTO.getEmail());
		employee.setName(employeeDTO.getName());
		employee.setDepartment(new Department(employeeDTO.getDepartmentId(), null));

		employee = repository.save(employee);
		return new EmployeeDTO(employee);
	}



}
