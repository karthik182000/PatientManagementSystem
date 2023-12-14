package org.application.service;

import org.application.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient updatePatient(Long patientId, Patient updatedPatient);
    void deletePatient(Long patientId);
    Patient getPatientById(Long patientId);
    List<Patient> getAllPatients();
    List<Patient> getPatientsAddedByUser(Long userId);
}

