package com.elx.coding.problem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elx.coding.problem.model.Employee;
import com.elx.coding.problem.repository.EmployeeRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/employee")
//@ComponentScan({"com.elx.coding.problem.repository"})
public class EmployeeController {

	@Autowired(required = true)
	EmployeeRepository employeeRepositry;

	// get all employees
	@PostMapping("/getallemployees")
	public List<Employee> getAllEmployees(@RequestBody Employee employee) throws ParseException {
		List<Employee> resultset;
		if (null != employee.getFname() && null !=employee.getStartDate() && null!=employee.getEndDate()) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			StringBuffer inputStartDate = new StringBuffer(employee.getStartDate());
			inputStartDate.append(" 00:00:00");
			StringBuffer inputEndDate = new StringBuffer(employee.getEndDate());
			inputEndDate.append(" 00:00:00");

			resultset = employeeRepositry.findbyname(employee.getFname().toLowerCase());
			// List<Employee> filteredList = resultset.stream()
			// .filter(r -> formatter.format(r.getStartDate()).equals(inputStartDate)
			// && formatter.format(r.getEndDate()).equals(inputEndDate))
			// .collect(Collectors.toList());

			List<Employee> filteredList = resultset.stream()
					.filter(r -> r.getStartDate().equals(inputStartDate.toString())
							&& r.getEndDate().equals(inputEndDate.toString()))
					.collect(Collectors.toList());
			Iterator<Employee> it = filteredList.iterator();
			List<Employee> formattedFilterList = new ArrayList<Employee>();
			/*
			 * while (it.hasNext()) { Employee employeeTemp = it.next();
			 * employeeTemp.setEndDate(formatter.parse(formatter.format(employeeTemp.
			 * getEndDate())));
			 * employeeTemp.setStartDate(formatter.parse(formatter.format(employeeTemp.
			 * getStartDate()))); formattedFilterList.add(employeeTemp); }
			 */

			return filteredList;

		}

		else

			return new ArrayList<Employee>();
		// return "this is ishank";

	}
}
