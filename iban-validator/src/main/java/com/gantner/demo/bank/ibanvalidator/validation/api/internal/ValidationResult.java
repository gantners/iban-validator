package com.gantner.demo.bank.ibanvalidator.validation.api.internal;

/**
 * The iban validation response object for communication with the frontend
 * 
 * @author Stefan Gantner
 */
public class ValidationResult {
    
    private boolean isValid;

    private String iban;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    private String bankName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    private String bic;

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}
