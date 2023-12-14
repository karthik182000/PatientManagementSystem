package org.application.service.impl;

import org.application.entity.Insurance;
import org.application.exceptions.InsuranceNotFoundException;
import org.application.repository.InsuranceRepository;
import org.application.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public Insurance createInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @Override
    public Insurance updateInsurance(Long insuranceId, Insurance updatedInsurance) {
        Optional<Insurance> existingInsuranceOptional = insuranceRepository.findById(insuranceId);
        if (existingInsuranceOptional.isPresent()) {
            Insurance existingInsurance = existingInsuranceOptional.get();
            existingInsurance.setProviderName(updatedInsurance.getProviderName());
            existingInsurance.setPolicyNumber(updatedInsurance.getPolicyNumber());
            // Update other attributes as needed
            return insuranceRepository.save(existingInsurance);
        } else {
            throw new InsuranceNotFoundException("Insurance not found with ID: " + insuranceId);
        }
    }

    @Override
    public void deleteInsurance(Long insuranceId) {
        insuranceRepository.deleteById(insuranceId);
    }
    @Override
    public Insurance getInsuranceById(Long insuranceId) {
        return insuranceRepository.findById(insuranceId)
                .orElseThrow(() -> new InsuranceNotFoundException("Insurance not found with ID: " + insuranceId));
    }
    @Override
    public List<Insurance> getAllInsurances() {
        return insuranceRepository.findAll();
    }

}

