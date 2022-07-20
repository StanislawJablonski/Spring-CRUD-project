package ug.edu.pl.javaee.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ug.edu.pl.javaee.project.domain.Employee;
import ug.edu.pl.javaee.project.domain.Smartphone;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
