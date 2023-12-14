package org.application.service;

import org.application.entity.ClinicalInfo;

import java.util.List;

public interface ClinicalInfoService {
    ClinicalInfo createClinicalInfo(ClinicalInfo clinicalInfo);
    ClinicalInfo updateClinicalInfo(Long clinicalInfoId, ClinicalInfo updatedClinicalInfo);
    void deleteClinicalInfo(Long clinicalInfoId);
    ClinicalInfo getClinicalInfoById(Long clinicalInfoId);
    List<ClinicalInfo> getAllClinicalInfo();

}

