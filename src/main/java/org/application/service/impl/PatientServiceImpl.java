package org.application.service.impl;

import org.application.entity.Patient;
import org.application.exceptions.PatientNotFoundException;
import org.application.repository.PatientRepository;
import org.application.service.PatientService;
import org.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final UserService userService;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, UserService userService) {
        this.patientRepository = patientRepository;
        this.userService = userService;
    }

    @Override
    public Patient createPatient(Patient patient) {
        if (patient.getFirstName() == null || patient.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("Patient's first name is required");
        }
        if (patient.getLastName() == null || patient.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Patient's first name is required");
        }
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long patientId, Patient updatedPatient) {
        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));

        existingPatient.setFirstName(updatedPatient.getFirstName());
        existingPatient.setLastName(updatedPatient.getLastName());


        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> getPatientsAddedByUser(Long userId) {
        return userService.getPatientsAddedByUser(userId);
    }
}

