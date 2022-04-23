package com.devsuperior.bds01.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;

@Service
public class DepartmentSerice {

	@Autowired
	private DepartmentRepository repository;

	@Transactional(readOnly = true)
	public List<DepartmentDTO> findAll() {

		List<Department> findAll = repository.findAll(Sort.by("Name"));
		
		return findAll.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList()); 
	}

}
