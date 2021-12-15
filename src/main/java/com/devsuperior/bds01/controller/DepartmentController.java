package com.devsuperior.bds01.controller;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {

        List<DepartmentDTO> list = departmentService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
