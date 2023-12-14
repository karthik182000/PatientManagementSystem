package org.application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clinical_information")
public class ClinicalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnosis;
    private String treatment;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public ClinicalInfo() {
    }

    public ClinicalInfo(Long id, String diagnosis, String treatment) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }
}

