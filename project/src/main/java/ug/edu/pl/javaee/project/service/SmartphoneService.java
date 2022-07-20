package ug.edu.pl.javaee.project.service;

import org.springframework.stereotype.Service;
import ug.edu.pl.javaee.project.domain.Smartphone;
import ug.edu.pl.javaee.project.repository.SmartphoneRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SmartphoneService {
    private final SmartphoneRepository smartphoneRepository;

    public SmartphoneService (SmartphoneRepository smartphoneRepository){
        this.smartphoneRepository = smartphoneRepository;
    }

    public Iterable<Smartphone> allSmartphones() { return smartphoneRepository.findAll(); }

    public Optional<Smartphone> findSmartphoneById(Long id) { return smartphoneRepository.findById(id); }

    public Smartphone addSmartphone(Smartphone smartphone) { return smartphoneRepository.save(smartphone); }

    public Smartphone updateSmartphone(Smartphone smartphone) {
        // https://www.baeldung.com/spring-data-crud-repository-save
        Smartphone smartphoneInDB = smartphoneRepository.findById(smartphone.getId()).get();
        smartphoneInDB.setName(smartphone.getName());
        smartphoneInDB.setClient(smartphone.getClient());
        smartphoneInDB.setPrice(smartphone.getPrice());
        smartphoneInDB.setProducer(smartphone.getProducer());
        smartphoneInDB.setEmployees(smartphone.getEmployees());
        return smartphoneRepository.save(smartphoneInDB);
    }

    public void deleteSmartphoneById(Long id) { smartphoneRepository.deleteById(id); }

    public long countSmartphones() { return smartphoneRepository.count(); }

    public void addRecords() {
        this.smartphoneRepository.save(new Smartphone("P20 Pro",2000));
        this.smartphoneRepository.save(new Smartphone("Galaxy S",500));
        this.smartphoneRepository.save(new Smartphone("Galaxy S 3",800));
        this.smartphoneRepository.save(new Smartphone("Galaxy S 10",2110));
        this.smartphoneRepository.save(new Smartphone("iPhone 10",4000));
        this.smartphoneRepository.save(new Smartphone("iPhone 6",1000));
        this.smartphoneRepository.save(new Smartphone("iPhone 12",6000));
        this.smartphoneRepository.save(new Smartphone("Iphone 36 Pro",999));
        this.smartphoneRepository.save(new Smartphone("P30",1999));
        this.smartphoneRepository.save(new Smartphone("P30 Pro",1767));
        this.smartphoneRepository.save(new Smartphone("10T",1955));
    }
}
