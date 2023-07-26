package com.gantner.demo.bank.ibanvalidator.validation.api.internal;

/**
 * Validation request object for requesting our api validate-iban endpoint
 * 
 * @author Stefan Gantner
 */
public class ValidationRequest {
    private String iban;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
