package org.application.controller;

import org.application.entity.Patient;
import org.application.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable("id") Long patientId, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(patientId, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable("id") Long patientId) {
        patientService.deletePatient(patientId);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long patientId) {
        return patientService.getPatientById(patientId);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
}
