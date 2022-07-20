package ug.edu.pl.javaee.project.domain;

import ug.edu.pl.javaee.project.validation.AlphanumericConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name can't be empty!")
    @NotNull(message = "Name can't be null!")
    @Size(min = 1, message = "Name must have at least 1 character!")
    private String name;
    private String country;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Smartphone> smartphones;


    public Producer (String name, String country, List<Smartphone> smartphones){
        this.name    = name;
        this.country = country;
        this.smartphones  = smartphones;
    }

    public Producer (String name, String country){
        this.name    = name;
        this.country = country;
    }

    public Producer (){
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

    public String getCountry (){
        return country;
    }

    public void setCountry (String country){
        this.country = country;
    }

    public List<Smartphone> getSmartphones (){
        return smartphones;
    }

    public void setSmartphones (List<Smartphone> smartphones){
        this.smartphones = smartphones;
    }
}

