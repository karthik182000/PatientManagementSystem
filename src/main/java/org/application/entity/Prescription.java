package org.application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicineName;
    private String dosage;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public Prescription() {
    }

    public Prescription(Long id, String medicineName, String dosage) {
        this.id = id;
        this.medicineName = medicineName;
        this.dosage = dosage;
    }
}

