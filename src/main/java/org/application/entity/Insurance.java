package org.application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "insurances")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String providerName;
    private String policyNumber;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Insurance() {
    }

    public Insurance(Long id, String providerName, String policyNumber) {
        this.id = id;
        this.providerName = providerName;
        this.policyNumber = policyNumber;
    }
}
