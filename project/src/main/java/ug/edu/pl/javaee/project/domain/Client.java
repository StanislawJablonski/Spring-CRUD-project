package ug.edu.pl.javaee.project.domain;

import ug.edu.pl.javaee.project.validation.AlphanumericConstraint;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name can't be empty!")
    @NotNull(message = "Name can't be null!")
    @Size(min = 1, message = "Name must have at least 1 character!")
    private String name;
    @NotNull
    @Min(1900)
    private int yob;

    @OneToOne
    @JoinColumn(name = "smartphone_id")
    private Smartphone smartphone;

    public Client (String name, int yob){
        this.name = name;
        this.yob  = yob;
    }

    public Client (String name, int yob, Smartphone smartphone){
        this.name       = name;
        this.yob        = yob;
        this.smartphone = smartphone;
    }

    public Client (){
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

    public int getYob (){
        return yob;
    }

    public void setYob (int yob){
        this.yob = yob;
    }

    public Smartphone getSmartphone (){
        return smartphone;
    }

    public void setSmartphone (Smartphone smartphone){
        this.smartphone = smartphone;
    }
}
