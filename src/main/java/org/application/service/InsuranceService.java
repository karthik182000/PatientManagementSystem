package org.application.service;

import org.application.entity.Insurance;

import java.util.List;

public interface InsuranceService {
    Insurance createInsurance(Insurance insurance);
    Insurance updateInsurance(Long insuranceId, Insurance updatedInsurance);
    void deleteInsurance(Long insuranceId);
    Insurance getInsuranceById(Long insuranceId);
    List<Insurance> getAllInsurances();
}

