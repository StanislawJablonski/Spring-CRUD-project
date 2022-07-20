package ug.edu.pl.javaee.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ug.edu.pl.javaee.project.domain.Employee;
import ug.edu.pl.javaee.project.service.EmployeeService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController (@Autowired EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public Iterable<Employee> allEmployees() {
        return employeeService.allEmployees();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/employee/updateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee){
        return  employeeService.updateEmployee(employee);
    }

    @GetMapping("/employee/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
}
