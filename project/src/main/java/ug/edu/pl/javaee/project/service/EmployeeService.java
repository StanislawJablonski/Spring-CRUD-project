package ug.edu.pl.javaee.project.service;

import org.springframework.stereotype.Service;
import ug.edu.pl.javaee.project.domain.Employee;
import ug.edu.pl.javaee.project.domain.Smartphone;
import ug.edu.pl.javaee.project.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> allEmployees() { return employeeRepository.findAll(); }

    public Optional<Employee> findEmployeeById(Long id) { return employeeRepository.findById(id); }

    public Employee addEmployee(Employee employee) { return employeeRepository.save(employee); }

    public Employee updateEmployee(Employee employee) {
        // https://www.baeldung.com/spring-data-crud-repository-save
        Employee employeeInDB = employeeRepository.findById(employee.getId()).get();
        employeeInDB.setName(employee.getName());
        employeeInDB.setSalary(employee.getSalary());
        employeeInDB.setSmartphones(employee.getSmartphones());
        return employeeRepository.save(employeeInDB);
    }

    public void deleteEmployeeById(Long id) { employeeRepository.deleteById(id); }

    public long countEmployees() { return employeeRepository.count(); }

    public void addRecords(){
        this.employeeRepository.save(new Employee("Adam",1000));
        this.employeeRepository.save(new Employee("Marcin",999));
        this.employeeRepository.save(new Employee("Szymon",1300));
        this.employeeRepository.save(new Employee("Jakub",9000));
        this.employeeRepository.save(new Employee("Jan",100));
        this.employeeRepository.save(new Employee("Mateusz",150));
        this.employeeRepository.save(new Employee("Katarzyna",1200));
        this.employeeRepository.save(new Employee("Agnieszka",8999));
        this.employeeRepository.save(new Employee("Zuzia",1000));
        this.employeeRepository.save(new Employee("Krystyna",1400));
        this.employeeRepository.save(new Employee("Monika",1123));


    }
}
