package com.devsuperior.bds01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.bds01.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}
