package com.gantner.demo.bank.ibanvalidator.validation.api.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * The iban validation response object for communication with the external api
 * 
 * @author Stefan Gantner
 */
public class IBANValidationResponse {

    @JsonProperty("valid")
    private Boolean valid;
    @JsonProperty("messages")
    private List<String> messages;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("bankData")
    private BankData bankData;

    @JsonProperty("valid")
    public Boolean getValid() {
        return valid;
    }

    @JsonProperty("valid")
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @JsonProperty("messages")
    public List<String> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @JsonProperty("iban")
    public String getIban() {
        return iban;
    }

    @JsonProperty("iban")
    public void setIban(String iban) {
        this.iban = iban;
    }

    @JsonProperty("bankData")
    public BankData getBankData() {
        return bankData;
    }

    @JsonProperty("bankData")
    public void setBankData(BankData bankData) {
        this.bankData = bankData;
    }
}