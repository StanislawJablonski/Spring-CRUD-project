package ug.edu.pl.javaee.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ug.edu.pl.javaee.project.domain.Producer;
import ug.edu.pl.javaee.project.domain.Smartphone;

public interface ProducerRepository extends CrudRepository<Producer,Long> {

}
