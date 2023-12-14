package org.application.service.impl;

import org.application.entity.ClinicalInfo;
import org.application.exceptions.ClinicalInfoNotFoundException;
import org.application.repository.ClinicalInfoRepository;
import org.application.service.ClinicalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicalInfoServiceImpl implements ClinicalInfoService {

    private final ClinicalInfoRepository clinicalInfoRepository;

    @Autowired
    public ClinicalInfoServiceImpl(ClinicalInfoRepository clinicalInfoRepository) {
        this.clinicalInfoRepository = clinicalInfoRepository;
    }

    @Override
    public ClinicalInfo createClinicalInfo(ClinicalInfo clinicalInfo) {
        return clinicalInfoRepository.save(clinicalInfo);
    }

    @Override
    public ClinicalInfo updateClinicalInfo(Long clinicalInfoId, ClinicalInfo updatedClinicalInfo) {
        Optional<ClinicalInfo> existingClinicalInfoOptional = clinicalInfoRepository.findById(clinicalInfoId);
        if (existingClinicalInfoOptional.isPresent()) {
            ClinicalInfo existingClinicalInfo = existingClinicalInfoOptional.get();
            existingClinicalInfo.setDiagnosis(updatedClinicalInfo.getDiagnosis());
            existingClinicalInfo.setTreatment(updatedClinicalInfo.getTreatment());
            return clinicalInfoRepository.save(existingClinicalInfo);
        } else {
            throw new ClinicalInfoNotFoundException("Clinical Information not found with ID: " + clinicalInfoId);
        }
    }

    @Override
    public void deleteClinicalInfo(Long clinicalInfoId) {
        clinicalInfoRepository.deleteById(clinicalInfoId);
    }

    @Override
    public ClinicalInfo getClinicalInfoById(Long clinicalInfoId) {
        return clinicalInfoRepository.findById(clinicalInfoId)
                .orElseThrow(() -> new ClinicalInfoNotFoundException("Clinical Information not found with ID: " + clinicalInfoId));
    }

    @Override
    public List<ClinicalInfo> getAllClinicalInfo() {
        return clinicalInfoRepository.findAll();
    }

}
