package com.synergisticit.runner;

import com.synergisticit.domain.Employee;
import com.synergisticit.repo.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRunner implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public EmployeeRunner(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Saving Employees ===");
        employeeRepository.save(new Employee("Alice", "Manager", 80000.0));
        employeeRepository.save(new Employee("Bob", "Developer", 65000.0));
        employeeRepository.save(new Employee("Carol", "Tester", 50000.0));

        System.out.println("\n=== Fetching All Employees ===");
        List<Employee> employees = employeeRepository.findAll();
        employees.forEach(System.out::println);

        System.out.println("\n=== Updating Employee ID 2 ===");
        Optional<Employee> optionalEmp = employeeRepository.findById(2);
        optionalEmp.ifPresent(emp -> {
            emp.setSalary(70000.0);
            employeeRepository.save(emp);
        });

        System.out.println("\n=== Deleting Employee ID 1 ===");
        employeeRepository.deleteById(1);

        System.out.println("\n=== Final Employee List ===");
        employeeRepository.findAll().forEach(System.out::println);
    }
}
