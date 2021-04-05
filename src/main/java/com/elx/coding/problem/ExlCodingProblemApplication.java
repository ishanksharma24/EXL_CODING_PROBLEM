
  package com.elx.coding.problem;
  
  import org.springframework.boot.SpringApplication; import
  org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
  
	@SpringBootApplication(scanBasePackages={"com.elx.coding.problem.controller", "com.elx.coding.problem.repository.EmployeeRepository"})
	@ComponentScan({"com.elx.coding.problem.controller"})
	@ComponentScan({"com.elx.coding.problem.repository.EmployeeRepository"})
	public class ExlCodingProblemApplication {
  
  public static void main(String[] args) {
  SpringApplication.run(ExlCodingProblemApplication.class, args); }
  
  }
 