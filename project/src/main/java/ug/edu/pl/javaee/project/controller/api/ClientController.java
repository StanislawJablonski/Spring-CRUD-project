package ug.edu.pl.javaee.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ug.edu.pl.javaee.project.domain.Client;
import ug.edu.pl.javaee.project.service.ClientService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {

    final ClientService clientService;

    public ClientController (@Autowired ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/client")
    public Iterable<Client> allClients() {
        return clientService.allClients();
    }

    @GetMapping("/client/{id}")
    public Optional<Client> getClientById(@PathVariable Long id){
        return clientService.findClientById(id);
    }

    @PostMapping("/client")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PostMapping("/client/updateClient/{id}")
    public Client updateClient(@RequestBody Client client){
        return  clientService.updateClient(client);
    }

    @GetMapping("/client/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClientById(id);
    }
}
