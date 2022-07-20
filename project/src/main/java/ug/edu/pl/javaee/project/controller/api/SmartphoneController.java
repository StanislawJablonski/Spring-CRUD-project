package ug.edu.pl.javaee.project.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ug.edu.pl.javaee.project.domain.Smartphone;
import ug.edu.pl.javaee.project.service.SmartphoneService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SmartphoneController {

    final SmartphoneService smartphoneService;

    public SmartphoneController (@Autowired SmartphoneService smartphoneService){
        this.smartphoneService = smartphoneService;
    }

    @GetMapping("/smartphone")
    public Iterable<Smartphone> allSmartphones() {
        return smartphoneService.allSmartphones();
    }

    @GetMapping("/smartphone/{id}")
    public Optional<Smartphone> getSmartphoneById(@PathVariable Long id){
        return smartphoneService.findSmartphoneById(id);
    }

    @PostMapping("/smartphone")
    public Smartphone addSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.addSmartphone(smartphone);
    }

    @PostMapping("/smartphone/updateSmartphone/{id}")
    public Smartphone updateSmartphone(@RequestBody Smartphone smartphone){
        return  smartphoneService.updateSmartphone(smartphone);
    }

    @GetMapping("/smartphone/deleteSmartphone/{id}")
    public void deleteSmartphone(@PathVariable Long id){
        smartphoneService.deleteSmartphoneById(id);
    }
}

