package com.pacewisdom.demo.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pacewisdom.demo.DemoForPacewisdomApplication;
import com.pacewisdom.demo.model.EmployeePOJO;
import com.pacewisdom.demo.repository.EmployeeRepository;
import com.pacewisdom.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoForPacewisdomApplication.class);
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<Object> addEmployeeService(EmployeePOJO employeePOJO) {
		LOGGER.info("Inside service method of adding employee API");
		String response = "";
		HttpStatus status = null;
		try {
			if (!employeeRepository.existsById(employeePOJO.getId())) {
				this.employeeRepository.save(employeePOJO);
				response = "Employee Added Successfully !!!";
				status = HttpStatus.OK;
				LOGGER.info("Emplyee has been added successfully");
			} else {
				LOGGER.info("Exception Generated during adding employee, Already Employee Exists.");
				throw new HibernateException("Employee Already Exist,Employee Could Not Added Please Try Later !!!");
			}

		} catch (HibernateException e) {
			LOGGER.info("Exception Handled", e);
			response = e.getMessage();
			status = HttpStatus.BAD_REQUEST;

		}
		return new ResponseEntity<Object>(response, status);
	}

	@Override
	public ResponseEntity<Object> getSingleEmployeeService(int id) {
		LOGGER.info("Inside service method of getting single employee API");
		Map<String, EmployeePOJO> response = new HashMap<String, EmployeePOJO>();
		HttpStatus status;
		EmployeePOJO employeePOJO = null;
		try {
			if (employeeRepository.existsById(id)) {
				employeePOJO = this.employeeRepository.findById(id).get();
				response.put("Requested Employee", employeePOJO);
				status = HttpStatus.OK;
				LOGGER.info("Emplyee has been retrieved successfully");
			} else {
				LOGGER.info("Exception Generated during retriving employee, Employee Doed Not Exists.");
				throw new HibernateException("Employee Does Not Exist");
			}

		} catch (HibernateException e) {
			LOGGER.info("Exception Handled", e);
			response.put(e.getMessage(), employeePOJO);
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<Object>(response, status);
	}

	@Override
	public ResponseEntity<Object> getAllEmployeeService() {
		LOGGER.info("Inside service method of getting list of employee API");
		List<EmployeePOJO> response;
		HttpStatus status;
		try {
			response = this.employeeRepository.findAll();
			status = HttpStatus.OK;
			LOGGER.info("Emplyee has been retrieved successfully");
		} catch (HibernateException e) {
			LOGGER.info("Exception Handled", e);
			response = null;
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<Object>(response, status);
	}

	@Override
	public ResponseEntity<Object> deleteSingleEmployeeService(int id) {
		LOGGER.info("Inside service method of deleting employee API");
		String response = "";
		HttpStatus status = null;
		try {
			if (employeeRepository.existsById(id)) {
				this.employeeRepository.deleteById(id);
				response = "Employee Deleted Successfully !!!";
				status = HttpStatus.OK;
				LOGGER.info("Emplyee has been deleted successfully");
			} else {
				LOGGER.info("Exception Generated during Deleting of employee, Employee Does Not Exists.");
				throw new HibernateException("Employee Does not Exist By Given ID");
			}

		} catch (HibernateException e) {
			LOGGER.info("Exception Handled", e);
			response = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<Object>(response, status);
	}

	@Override
	public ResponseEntity<Object> updateEmployeeService(EmployeePOJO employeePOJO) {
		LOGGER.info("Inside service method of Updating employee API");
		String response = "";
		HttpStatus status;
		try {
			if (employeeRepository.existsById(employeePOJO.getId())) {
				EmployeePOJO updatedEmployee = employeeRepository.findById(employeePOJO.getId()).get();
				updatedEmployee.setId(employeePOJO.getId());
				updatedEmployee.setFirstName(employeePOJO.getFirstName());
				updatedEmployee.setLastName(employeePOJO.getLastName());
				updatedEmployee.setEmailId(employeePOJO.getEmailId());
				updatedEmployee.setGender(employeePOJO.getGender());
				updatedEmployee.setAddress(employeePOJO.getAddress());
				updatedEmployee.setAge(employeePOJO.getAge());
				this.employeeRepository.save(updatedEmployee);
				response = "Employee Updated Successfully !!!";
				status = HttpStatus.OK;
				LOGGER.info("Employee Has been updated Successfully");
			} else {
				LOGGER.info("Exception Generated during Updating of employee, Employee Does Not Exists.");
				throw new HibernateException("Employee Does Not Exist");
			}
		} catch (HibernateException e) {
			LOGGER.info("Exception Handled", e);
			response = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<Object>(response, status);
	}

}
