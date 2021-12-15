package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> findAll() {

        List<Department> list = departmentRepository.findAll();
        List<DepartmentDTO> listDTO = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            listDTO.add(entityToDTO(list.get(i)));
        }

        return listDTO;
    }

    public DepartmentDTO entityToDTO(Department department) {

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());

        return departmentDTO;
    }
}
