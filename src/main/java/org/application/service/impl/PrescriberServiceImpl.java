package org.application.service.impl;
import org.application.exceptions.PrescriberNotFoundException;
import org.application.entity.Prescriber;
import org.application.repository.PrescriberRepository;
import org.application.service.PrescriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriberServiceImpl implements PrescriberService {

    private final PrescriberRepository prescriberRepository;

    @Autowired
    public PrescriberServiceImpl(PrescriberRepository prescriberRepository) {
        this.prescriberRepository = prescriberRepository;
    }

    @Override
    public Prescriber createPrescriber(Prescriber prescriber) {
        return prescriberRepository.save(prescriber);
    }

    @Override
    public Prescriber updatePrescriber(Long prescriberId, Prescriber updatedPrescriber) {
        Optional<Prescriber> existingPrescriberOptional = prescriberRepository.findById(prescriberId);
        if (existingPrescriberOptional.isPresent()) {
            Prescriber existingPrescriber = existingPrescriberOptional.get();
            existingPrescriber.setName(updatedPrescriber.getName());
            existingPrescriber.setSpecialization(updatedPrescriber.getSpecialization());
            // Update other attributes as needed
            return prescriberRepository.save(existingPrescriber);
        } else throw new PrescriberNotFoundException("Prescriber not found with ID: " + prescriberId);
    }

    @Override
    public void deletePrescriber(Long prescriberId) {
        prescriberRepository.deleteById(prescriberId);
    }

    @Override
    public Prescriber getPrescriberById(Long prescriberId) {
        return prescriberRepository.findById(prescriberId)
                .orElseThrow(() -> new PrescriberNotFoundException("Prescriber not found with ID: " + prescriberId));
    }

    @Override
    public List<Prescriber> getAllPrescribers() {
        return prescriberRepository.findAll();
    }

}
