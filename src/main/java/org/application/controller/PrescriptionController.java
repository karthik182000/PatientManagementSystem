package org.application.controller;

import org.application.entity.Prescription;
import org.application.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.createPrescription(prescription);
    }

    @PutMapping("/{id}")
    public Prescription updatePrescription(@PathVariable("id") Long prescriptionId, @RequestBody Prescription updatedPrescription) {
        return prescriptionService.updatePrescription(prescriptionId, updatedPrescription);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable("id") Long prescriptionId) {
        prescriptionService.deletePrescription(prescriptionId);
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable("id") Long prescriptionId) {
        return prescriptionService.getPrescriptionById(prescriptionId);
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

}
