package com.devsuperior.bds01.controller;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll(
            @PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<EmployeeDTO> response = employeeService.findAll(pageable);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO employeeDTO){
        
        employeeDTO = employeeService.insert(employeeDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(employeeDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(employeeDTO);
    }

}
