package com.devsuperior.bds01.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	public DepartmentRepository departmentRepository;
	
	public List<DepartmentDTO> findAll() {
		List<Department> listDepartment = departmentRepository.findAll(Sort.by("name"));
				
		List<DepartmentDTO> listDepartmentDto = listDepartment.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
		
		return listDepartmentDto;
	}

}
