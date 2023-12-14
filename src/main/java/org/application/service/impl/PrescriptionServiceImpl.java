package org.application.service.impl;

import org.application.entity.Prescription;
import org.application.exceptions.PrescriptionNotFoundException;
import org.application.repository.PrescriptionRepository;
import org.application.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }


    @Override
    public Prescription updatePrescription(Long prescriptionId, Prescription updatedPrescription) {
        Optional<Prescription> existingPrescriptionOptional = prescriptionRepository.findById(prescriptionId);
        if (existingPrescriptionOptional.isPresent()) {
            Prescription existingPrescription = existingPrescriptionOptional.get();
            existingPrescription.setMedicineName(updatedPrescription.getMedicineName());
            existingPrescription.setDosage(updatedPrescription.getDosage());

            return prescriptionRepository.save(existingPrescription);
        } else {
            throw new PrescriptionNotFoundException("Prescription not found with ID: " + prescriptionId);
        }
    }

    @Override
    public Prescription createPrescription(Prescription prescription) {
        return null;
    }

    @Override
    public void deletePrescription(Long prescriptionId) {
        prescriptionRepository.deleteById(prescriptionId);
    }

    @Override
    public Prescription getPrescriptionById(Long prescriptionId) {
        return prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription not found with ID: " + prescriptionId));
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

}


