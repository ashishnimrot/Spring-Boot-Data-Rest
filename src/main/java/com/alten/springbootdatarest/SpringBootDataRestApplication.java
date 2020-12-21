package com.alten.springbootdatarest;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alten.springbootdatarest.model.Employee;
import com.alten.springbootdatarest.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootDataRestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDataRestApplication.class, args);
		EmployeeRepository repository = context.getBean(EmployeeRepository.class);
		
		Employee employee = new Employee();
//		employee.setEmpId(2);
		employee.setDeptId(4);
		employee.setFirstName("Ashish");
		employee.setLastName("Nimrot");
		employee.setSalary(100000.0f);
		
		Employee saveEmployee = repository.save(employee);
		System.out.println(saveEmployee);
//		System.out.println(saveEmployee.toString());
//		repository.deleteById(employee.getEmpId());
		System.out.println("Hello");
		
		try {
//			repository.findByFirstNameContaining("Thakur").get().forEach(System.out::println);
//			repository.findByFirstNameLike("%Thakur%").get().forEach(System.out::println);
//			repository.findByFirstNameStartsWith("Ashish").get().forEach(System.out::println);
			
			repository.findMaxSalariesByDeptId(Arrays.asList("Ashish", "Sumit")).forEach(e -> {
				for(Object o : e) {
					System.out.println(o);
				}
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
