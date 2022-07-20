package ug.edu.pl.javaee.project.repository;

import org.springframework.data.repository.CrudRepository;
import ug.edu.pl.javaee.project.domain.Client;
import ug.edu.pl.javaee.project.domain.Smartphone;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
