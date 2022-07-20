package ug.edu.pl.javaee.project.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ug.edu.pl.javaee.project.domain.Client;
import ug.edu.pl.javaee.project.domain.Employee;
import ug.edu.pl.javaee.project.domain.Producer;
import ug.edu.pl.javaee.project.domain.Smartphone;
import ug.edu.pl.javaee.project.service.ClientService;
import ug.edu.pl.javaee.project.service.EmployeeService;
import ug.edu.pl.javaee.project.service.ProducerService;
import ug.edu.pl.javaee.project.service.SmartphoneService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class WebSmartphoneController {
    private final SmartphoneService smartphoneService;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final ProducerService producerService;

    public WebSmartphoneController(@Autowired SmartphoneService smartphoneService,@Autowired ClientService clientService,
                                   @Autowired EmployeeService employeeService,ProducerService producerService) {
        this.smartphoneService = smartphoneService;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.producerService = producerService;
    }

    @GetMapping("/smartphone")
    public String smartphones(Model model) {
        model.addAttribute("allSmartphonesFromDB", smartphoneService.allSmartphones());
        return "smartphone-all";
    }

    @PostMapping("/addSmartphone")
    public String addSmartphone(@Valid @ModelAttribute("smartphone") Smartphone smartphone, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println("Error found in addSmartphone");
            return "redirect:/smartphone";
        }
        smartphoneService.addSmartphone(smartphone);
        return "redirect:/smartphone";
    }

    @GetMapping("/newSmartphoneForm")
    public String newSmartphoneForm(Model model) {
        Smartphone smartphone = new Smartphone();
        Iterable<Client> listClients = clientService.allClients();
        Iterable<Employee> listEmployees = employeeService.allEmployees();
        Iterable<Producer> listProducers = producerService.allProducers();
        model.addAttribute("smartphone", smartphone);
        model.addAttribute("listClients",listClients);
        model.addAttribute("listEmployees",listEmployees);
        model.addAttribute("listProducers",listProducers);
        return "smartphone-new";
    }
    @GetMapping("/deleteSmartphone/{id}")
    public String deleteSmartphone(@PathVariable Long id){
        smartphoneService.deleteSmartphoneById(id);
        return "redirect:/smartphone";
    }
    @GetMapping("/updateSmartphoneForm/{id}")
    public String updateSmartphoneForm(@PathVariable ( value = "id") Long id, Model model) {
        Optional<Smartphone> smartphone = smartphoneService.findSmartphoneById(id);
        Iterable<Client> listClients = clientService.allClients();
        Iterable<Employee> listEmployees = employeeService.allEmployees();
        Iterable<Producer> listProducers = producerService.allProducers();
        model.addAttribute("smartphone", smartphone);
        model.addAttribute("listClients",listClients);
        model.addAttribute("listEmployees",listEmployees);
        model.addAttribute("listProducers",listProducers);
        return "smartphone-update";
    }

    @PostMapping("/updateSmartphone")
    public String updateSmartphone(@Valid @ModelAttribute("smartphone") Smartphone smartphone, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("Error found in updateSmartphone");
            return "redirect:/smartphone";
        }
        smartphoneService.updateSmartphone(smartphone);
        return "redirect:/smartphone";
    }
}
