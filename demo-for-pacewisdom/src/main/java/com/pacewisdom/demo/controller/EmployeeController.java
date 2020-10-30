package com.pacewisdom.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pacewisdom.demo.model.EmployeePOJO;
import com.pacewisdom.demo.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	// API For Storing single Employee in database
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeePOJO employeePOJO) {
		LOGGER.info("Calling API For adding Employee");
		return this.employeeService.addEmployeeService(employeePOJO);
	}

	// API For Updating Existing Employee in database
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PATCH)
	public ResponseEntity<Object> updateEmployee(@RequestBody EmployeePOJO employeePOJO) {
		LOGGER.info("Calling API For Updating Employee");
		return this.employeeService.updateEmployeeService(employeePOJO);
	}

	// API For Getting Single Employee Based on Employee Id
	@RequestMapping(value = "/getSingleEmployee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getSingleEmployee(@PathVariable int id) {
		LOGGER.info("Calling API For getting single Employee");
		return this.employeeService.getSingleEmployeeService(id);
	}

	// API For Getting List OF All Employee in database
	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllEmployee() {
		LOGGER.info("Calling API For getting list of Employee");
		return this.employeeService.getAllEmployeeService();
	}

	// API For Deleting Employee Based On Employee Id
	@RequestMapping(value = "/deleteSingleEmployee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteOneEmployee(@PathVariable int id) {
		LOGGER.info("Calling API For Deleting Employee");
		return this.employeeService.deleteSingleEmployeeService(id);
	}

}
