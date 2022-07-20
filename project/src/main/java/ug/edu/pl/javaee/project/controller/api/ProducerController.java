package ug.edu.pl.javaee.project.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ug.edu.pl.javaee.project.domain.Producer;
import ug.edu.pl.javaee.project.service.ProducerService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProducerController {

    final ProducerService producerService;

    public ProducerController (@Autowired ProducerService producerService){
        this.producerService = producerService;
    }

    @GetMapping("/producer")
    public Iterable<Producer> allProducers() {
        return producerService.allProducers();
    }

    @GetMapping("/producer/{id}")
    public Optional<Producer> getProducerById(@PathVariable Long id){
        return producerService.findProducerById(id);
    }

    @PostMapping("/producer")
    public Producer addProducer(@RequestBody Producer producer) {
        return producerService.addProducer(producer);
    }

    @PostMapping("/producer/updateProducer/{id}")
    public Producer updateProducer(@RequestBody Producer producer){
        return  producerService.updateProducer(producer);
    }

    @GetMapping("/producer/deleteProducer/{id}")
    public void deleteProducer(@PathVariable Long id){
        producerService.deleteProducerById(id);
    }
}
