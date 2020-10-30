package com.pacewisdom.demo.service;

import org.springframework.http.ResponseEntity;

import com.pacewisdom.demo.model.EmployeePOJO;

public interface EmployeeService {

	public ResponseEntity<Object> addEmployeeService(EmployeePOJO employeePOJO);

	public ResponseEntity<Object> getSingleEmployeeService(int id);

	public ResponseEntity<Object> getAllEmployeeService();

	public ResponseEntity<Object> deleteSingleEmployeeService(int id);

	public ResponseEntity<Object> updateEmployeeService(EmployeePOJO employeePOJO);

}
