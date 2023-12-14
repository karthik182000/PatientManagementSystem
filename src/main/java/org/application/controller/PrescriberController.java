package org.application.controller;

import org.application.entity.Prescriber;
import org.application.service.PrescriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescribers")
public class PrescriberController {

    private final PrescriberService prescriberService;

    @Autowired
    public PrescriberController(PrescriberService prescriberService) {
        this.prescriberService = prescriberService;
    }

    @PostMapping
    public Prescriber createPrescriber(@RequestBody Prescriber prescriber) {
        return prescriberService.createPrescriber(prescriber);
    }

    @PutMapping("/{id}")
    public Prescriber updatePrescriber(@PathVariable("id") Long prescriberId, @RequestBody Prescriber updatedPrescriber) {
        return prescriberService.updatePrescriber(prescriberId, updatedPrescriber);
    }

    @DeleteMapping("/{id}")
    public void deletePrescriber(@PathVariable("id") Long prescriberId) {
        prescriberService.deletePrescriber(prescriberId);
    }

    @GetMapping("/{id}")
    public Prescriber getPrescriberById(@PathVariable("id") Long prescriberId) {
        return prescriberService.getPrescriberById(prescriberId);
    }

    @GetMapping
    public List<Prescriber> getAllPrescribers() {
        return prescriberService.getAllPrescribers();
    }

}

