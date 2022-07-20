package ug.edu.pl.javaee.project.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ug.edu.pl.javaee.project.domain.Client;
import ug.edu.pl.javaee.project.domain.Smartphone;
import ug.edu.pl.javaee.project.service.ClientService;
import ug.edu.pl.javaee.project.service.SmartphoneService;

import javax.validation.Valid;
import java.util.Optional;
@Controller
public class WebClientController {

    private final ClientService clientService;
    private final SmartphoneService smartphoneService;

    public WebClientController(@Autowired ClientService clientService,@Autowired SmartphoneService smartphoneService) {
        this.clientService = clientService;
        this.smartphoneService = smartphoneService;
    }

    @GetMapping("/client")
    public String clients(Model model) {
        model.addAttribute("allClientsFromDB", clientService.allClients());
        return "client-all";
    }

    @PostMapping("/addClient")
    public String addClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println("Error found in addClient");
            return "redirect:/client";
        }
        clientService.addClient(client);
        return "redirect:/client";
    }

    @GetMapping("/newClientForm")
    public String newClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        Iterable<Smartphone> listSmartphones = smartphoneService.allSmartphones();
        model.addAttribute("listSmartphones",listSmartphones);
        return "client-new";
    }
    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable Long id){
        clientService.deleteClientById(id);
        return "redirect:/client";
    }
    @GetMapping("/updateClientForm/{id}")
    public String updateClientForm(@PathVariable ( value = "id") Long id, Model model) {
        Optional<Client> client = clientService.findClientById(id);
        model.addAttribute("client", client);
        Iterable<Smartphone> listSmartphones = smartphoneService.allSmartphones();
        model.addAttribute("listSmartphones",listSmartphones);
        return "client-update";
    }

    @PostMapping("/updateClient")
    public String updateClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("Error found in updateClient");
            return "redirect:/client";
        }
        clientService.updateClient(client);
        return "redirect:/client";
    }
}
