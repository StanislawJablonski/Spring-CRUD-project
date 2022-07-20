package ug.edu.pl.javaee.project.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ug.edu.pl.javaee.project.domain.Producer;
import ug.edu.pl.javaee.project.domain.Smartphone;
import ug.edu.pl.javaee.project.service.ProducerService;
import ug.edu.pl.javaee.project.service.SmartphoneService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class WebProducerController {
    private final ProducerService producerService;
    private final SmartphoneService smartphoneService;

    public WebProducerController(@Autowired ProducerService producerService,@Autowired SmartphoneService smartphoneService) {
        this.producerService = producerService;
        this.smartphoneService = smartphoneService;
    }

    @GetMapping("/producer")
    public String producers(Model model) {
        model.addAttribute("allProducersFromDB", producerService.allProducers());
        return "producer-all";
    }

    @PostMapping("/addProducer")
    public String addProducer(@Valid @ModelAttribute("producer") Producer producer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println("Error found in addProducer");
            return "redirect:/producer";
        }
        producerService.addProducer(producer);
        return "redirect:/producer";
    }

    @GetMapping("/newProducerForm")
    public String newProducerForm(Model model) {
        Producer producer = new Producer();
        model.addAttribute("producer", producer);
        Iterable<Smartphone> listSmartphones = smartphoneService.allSmartphones();
        model.addAttribute("listSmartphones",listSmartphones);
        return "producer-new";
    }
    @GetMapping("/deleteProducer/{id}")
    public String deleteProducer(@PathVariable Long id){
        producerService.deleteProducerById(id);
        return "redirect:/producer";
    }
    @GetMapping("/updateProducerForm/{id}")
    public String updateProducerForm(@PathVariable ( value = "id") Long id, Model model) {
        Optional<Producer> producer = producerService.findProducerById(id);
        model.addAttribute("producer", producer);
        Iterable<Smartphone> listSmartphones = smartphoneService.allSmartphones();
        model.addAttribute("listSmartphones",listSmartphones);
        return "producer-update";
    }

    @PostMapping("/updateProducer")
    public String updateProducer(@Valid @ModelAttribute("producer") Producer producer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("Error found in updateProducer");
            return "redirect:/producer";
        }
        producerService.updateProducer(producer);
        return "redirect:/producer";
    }
}
