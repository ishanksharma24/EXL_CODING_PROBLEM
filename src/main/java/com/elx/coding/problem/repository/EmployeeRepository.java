package com.elx.coding.problem.repository;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.elx.coding.problem.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

	@Query("Select E from Employee E where lower(E.fname)=?1 or lower(E.lname)=?1")
	public List<Employee> findbyname(String name);

}
