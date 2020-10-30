package com.pacewisdom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pacewisdom.demo.model.EmployeePOJO;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePOJO, Integer> {

}
