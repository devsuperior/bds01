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
public class DepartmentServices {

	@Autowired
	private DepartmentRepository repository;
	
	public List<DepartmentDTO> findAll(){
		List<Department> list = repository.findAll(Sort.by("name")); //Retorna ordenado por nome;
		
		return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList()); //Percorre a lista e retorna um DTO;
	}
}
