package ug.edu.pl.javaee.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ug.edu.pl.javaee.project.domain.Client;
import ug.edu.pl.javaee.project.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Iterable<Client> allClients() { return clientRepository.findAll(); }

    public Optional<Client> findClientById(Long id) { return clientRepository.findById(id); }

    public Client addClient(Client client) { return clientRepository.save(client); }

    public Client updateClient(Client client) {
        // https://www.baeldung.com/spring-data-crud-repository-save
        Client clientInDB = clientRepository.findById(client.getId()).get();
        clientInDB.setName(client.getName());
        clientInDB.setYob(client.getYob());
        clientInDB.setSmartphone(client.getSmartphone());
        return clientRepository.save(clientInDB);
    }

    public void deleteClientById(Long id) { clientRepository.deleteById(id); }

    public long countClients() { return clientRepository.count(); }

    public void addRecords(){
        this.clientRepository.save(new Client("Stanislaw", 1999));
        this.clientRepository.save(new Client("Jan", 1988));
        this.clientRepository.save(new Client("Krzysztof", 2000));
        this.clientRepository.save(new Client("Franciszek", 1937));
        this.clientRepository.save(new Client("Szymon", 1970));
        this.clientRepository.save(new Client("Marek", 1987));
        this.clientRepository.save(new Client("Kamil", 2001));
        this.clientRepository.save(new Client("Agata", 2007));
        this.clientRepository.save(new Client("Aleksandra", 1996));
        this.clientRepository.save(new Client("Julia", 1995));
        this.clientRepository.save(new Client("Klaudia", 1972));
    }

}
