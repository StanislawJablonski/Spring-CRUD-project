package ug.edu.pl.javaee.project.domain;

import ug.edu.pl.javaee.project.validation.AlphanumericConstraint;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name can't be empty!")
    @NotNull(message = "Name can't be null!")
    @Size(min = 1, message = "Name must have at least 1 character!")
    private String name;
    @NotNull
    @Min(0)
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "smartphone_employee",
            joinColumns = @JoinColumn(name = "smartphone_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id",
                    referencedColumnName = "id"))
    private List<Smartphone> smartphones;

    public Employee (){
    }

    public Employee (String name, int salary){
        this.name   = name;
        this.salary = salary;
    }

    public Employee (String name, int salary, List<Smartphone> smartphones){
        this.name        = name;
        this.salary      = salary;
        this.smartphones = smartphones;
    }

    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public int getSalary (){
        return salary;
    }

    public void setSalary (int salary){
        this.salary = salary;
    }

    public List<Smartphone> getSmartphones (){
        return smartphones;
    }

    public void setSmartphones (List<Smartphone> smartphones){
        this.smartphones = smartphones;
    }
}
