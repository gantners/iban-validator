package com.gantner.demo.bank.ibanvalidator.validation.service;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gantner.demo.bank.ibanvalidator.validation.api.external.IBANValidationResponse;
import com.gantner.demo.bank.ibanvalidator.validation.api.internal.ValidationResult;
import com.gantner.demo.bank.ibanvalidator.validation.entity.BankEntity;
import com.gantner.demo.bank.ibanvalidator.validation.repository.BankRepository;

import jakarta.annotation.Nonnull;

@Service
/**
 * The bank service class for iban validation and bank data retrieval
 * @author Stefan Gantner
 */
public class BankService {

    private final String API_URL = "https://www.openiban.com/validate/%s?validateBankCode=true&getBIC=true";

    private final BankRepository bankRepository;

    public BankService( @Nonnull BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public ValidationResult validateIBAN(@Nonnull String ibanUserInput) {
        Objects.requireNonNull(ibanUserInput, "Iban must not be empty!");

        ValidationResult result = new ValidationResult();

        try {
            //Clean user input
            String cleanedIban = cleanIbanString(ibanUserInput);
            BankEntity foundIban = bankRepository.findByIban(cleanedIban);
            
            if (foundIban == null) {
                // Resolve bic and bankName external
                IBANValidationResponse responseData = getBankDetailsFromExternalAPI(cleanedIban);
                if(responseData.getValid()){
                    //Add to database
                    BankEntity newBankEntity = new BankEntity();
                    newBankEntity.setBankName(responseData.getBankData().getName());
                    newBankEntity.setBic(responseData.getBankData().getBic());
                    newBankEntity.setIban(responseData.getIban());
                    newBankEntity = bankRepository.save(newBankEntity);

                    result.setBankName(newBankEntity.getBankName());
                    result.setBic(newBankEntity.getBic());
                    result.setValid(true);
                    result.setIban(newBankEntity.getIban());
                }else{
                    result.setValid(false);
                }
            } else {
                // return already saved result
                result.setBankName(foundIban.getBankName());
                result.setBic(foundIban.getBic());
                result.setValid(true);
                result.setIban(foundIban.getIban());
            }

        } catch (Exception e) {
            result.setValid(false);
        }

        return result;
    }
    /**
     * @param bankEntity must not be {@literal null}.
	 * @return the saved bankEntity; will never be {@literal null}.
	 * @throws NullPointerException in case the given {@literal entity} is {@literal null}.
     */
    public BankEntity saveBankEntity(@Nonnull BankEntity bankEntity) {
        Objects.requireNonNull(bankEntity, "Bank Entity must not be null!");
        return bankRepository.save(bankEntity);
    }

    public IBANValidationResponse getBankDetailsFromExternalAPI(@Nonnull String iban) {
        Objects.requireNonNull(iban, "Iban must not be empty!");

        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(String.format(API_URL,iban), IBANValidationResponse.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Removes any unallowed characters from a string and returns the iban in uppercase format
     * @param dirtyIban
     * @return
     */
    public String cleanIbanString(@Nonnull String dirtyIban) {
        Objects.requireNonNull(dirtyIban, "Iban must not be empty!");
        return dirtyIban.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
    }
}
