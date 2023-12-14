package org.application.service;

import org.application.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    Prescription createPrescription(Prescription prescription);
    Prescription updatePrescription(Long prescriptionId, Prescription updatedPrescription);
    void deletePrescription(Long prescriptionId);
    Prescription getPrescriptionById(Long prescriptionId);
    List<Prescription> getAllPrescriptions();

}

