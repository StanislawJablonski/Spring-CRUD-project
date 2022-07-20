package ug.edu.pl.javaee.project.service;

import org.springframework.stereotype.Service;
import ug.edu.pl.javaee.project.domain.Producer;
import ug.edu.pl.javaee.project.repository.ProducerRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProducerService {
    private final ProducerRepository producerRepository;

    public ProducerService (ProducerRepository producerRepository){
        this.producerRepository = producerRepository;
    }

    public Iterable<Producer> allProducers() { return producerRepository.findAll(); }

    public Optional<Producer> findProducerById(Long id) { return producerRepository.findById(id); }

    public Producer addProducer(Producer producer) { return producerRepository.save(producer); }

    public Producer updateProducer(Producer producer) {
        // https://www.baeldung.com/spring-data-crud-repository-save
        Producer producerInDB = producerRepository.findById(producer.getId()).get();
        producerInDB.setName(producer.getName());
        producerInDB.setCountry(producer.getCountry());
        producerInDB.setSmartphones(producer.getSmartphones());
        return producerRepository.save(producerInDB);
    }

    public void deleteProducerById(Long id) { producerRepository.deleteById(id); }

    public long countProducers() { return producerRepository.count(); }

    public void addRecords() {
        this.producerRepository.save(new Producer("Huawei","China"));
        this.producerRepository.save(new Producer("Samsung","South Korea"));
        this.producerRepository.save(new Producer("Xiaomi","China"));
        this.producerRepository.save(new Producer("Sony","China"));
        this.producerRepository.save(new Producer("One Plus","USA"));
        this.producerRepository.save(new Producer("Nokia","Iceland"));
        this.producerRepository.save(new Producer("Apple","USA"));
        this.producerRepository.save(new Producer("Motorola","Poland"));
        this.producerRepository.save(new Producer("Blackberry","Poland"));
        this.producerRepository.save(new Producer("Oppo","China"));


    }
}
