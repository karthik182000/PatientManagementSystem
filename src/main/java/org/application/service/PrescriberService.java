package org.application.service;

import org.application.entity.Prescriber;

import java.util.List;

public interface PrescriberService {
    Prescriber createPrescriber(Prescriber prescriber);
    Prescriber updatePrescriber(Long prescriberId, Prescriber updatedPrescriber);
    void deletePrescriber(Long prescriberId);
    Prescriber getPrescriberById(Long prescriberId);

    List<Prescriber> getAllPrescribers();
}

