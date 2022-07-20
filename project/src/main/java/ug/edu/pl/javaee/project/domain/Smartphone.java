package ug.edu.pl.javaee.project.domain;

import ug.edu.pl.javaee.project.validation.AlphanumericConstraint;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name can't be empty!")
    @NotNull(message = "Name can't be null!")
    @Size(min = 1, message = "Name must have at least 1 character!")
    private String name;
    @NotNull
    @Min(0)
    private int price;

    @OneToOne
    private Client client;
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Smartphone (){
    }

    public Smartphone (String name, int price){
        this.name  = name;
        this.price = price;
    }

    public Smartphone (String name, int price, Client client, Producer producer, List<Employee> employees){
        this.name      = name;
        this.price     = price;
        this.client    = client;
        this.producer  = producer;
        this.employees = employees;
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

    public int getPrice (){
        return price;
    }

    public void setPrice (int price){
        this.price = price;
    }

    public Client getClient (){
        return client;
    }

    public void setClient (Client client){
        this.client = client;
    }

    public Producer getProducer (){
        return producer;
    }

    public void setProducer (Producer producer){
        this.producer = producer;
    }

    public List<Employee> getEmployees (){
        return employees;
    }

    public void setEmployees (List<Employee> employees){
        this.employees = employees;
    }
}

