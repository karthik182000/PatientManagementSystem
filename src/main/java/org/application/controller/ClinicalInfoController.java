package org.application.controller;

import org.application.entity.ClinicalInfo;
import org.application.service.ClinicalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinicalinfo")
public class ClinicalInfoController {

    private final ClinicalInfoService clinicalInfoService;

    @Autowired
    public ClinicalInfoController(ClinicalInfoService clinicalInfoService) {
        this.clinicalInfoService = clinicalInfoService;
    }

    @PostMapping
    public ClinicalInfo createClinicalInfo(@RequestBody ClinicalInfo clinicalInfo) {
        return clinicalInfoService.createClinicalInfo(clinicalInfo);
    }

    @PutMapping("/{id}")
    public ClinicalInfo updateClinicalInfo(@PathVariable("id") Long clinicalInfoId, @RequestBody ClinicalInfo updatedClinicalInfo) {
        return clinicalInfoService.updateClinicalInfo(clinicalInfoId, updatedClinicalInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteClinicalInfo(@PathVariable("id") Long clinicalInfoId) {
        clinicalInfoService.deleteClinicalInfo(clinicalInfoId);
    }

    @GetMapping("/{id}")
    public ClinicalInfo getClinicalInfoById(@PathVariable("id") Long clinicalInfoId) {
        return clinicalInfoService.getClinicalInfoById(clinicalInfoId);
    }

    @GetMapping
    public List<ClinicalInfo> getAllClinicalInfo() {
        return clinicalInfoService.getAllClinicalInfo();
    }

}

