package com.devsuperior.bds01.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.services.EmployeeService;


@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable){
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
		
		Page<EmployeeDTO> pageEmployess = employeeService.findAll(pageRequest);
		
		return ResponseEntity.ok().body(pageEmployess);
	}

	@PostMapping
	ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO employee) {
		EmployeeDTO newEmployeeDto = employeeService.insert(employee);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newEmployeeDto.getId())
				.toUri();

		return ResponseEntity.created(uri).body(newEmployeeDto); // o método created, retorna um status 201, criado.
		
	}
	
}
