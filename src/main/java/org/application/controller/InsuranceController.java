package org.application.controller;

import org.application.entity.Insurance;
import org.application.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {

    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping
    public Insurance createInsurance(@RequestBody Insurance insurance) {
        return insuranceService.createInsurance(insurance);
    }

    @PutMapping("/{id}")
    public Insurance updateInsurance(@PathVariable("id") Long insuranceId, @RequestBody Insurance updatedInsurance) {
        return insuranceService.updateInsurance(insuranceId, updatedInsurance);
    }

    @DeleteMapping("/{id}")
    public void deleteInsurance(@PathVariable("id") Long insuranceId) {
        insuranceService.deleteInsurance(insuranceId);
    }

    @GetMapping("/{id}")
    public Insurance getInsuranceById(@PathVariable("id") Long insuranceId) {
        return insuranceService.getInsuranceById(insuranceId);
    }

    @GetMapping
    public List<Insurance> getAllInsurances() {
        return insuranceService.getAllInsurances();
    }
}

