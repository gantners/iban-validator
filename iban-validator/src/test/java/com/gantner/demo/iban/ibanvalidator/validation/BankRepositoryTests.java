package com.gantner.demo.iban.ibanvalidator.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gantner.demo.bank.ibanvalidator.ValidatorApplication;
import com.gantner.demo.bank.ibanvalidator.validation.entity.BankEntity;
import com.gantner.demo.bank.ibanvalidator.validation.repository.BankRepository;

@SpringBootTest(classes=ValidatorApplication.class)
/**
 * @author Stefan Gantner
 */
public class BankRepositoryTests {
    
    @Autowired
    BankRepository bankRepository;
    
    @Test
	void contextLoads() {}

    @Test
    /**
     * Save a BankEntity and verify that it has been assigned an ID and the name is saved correctly
     */
	void testSaveBankEntity(){
		BankEntity bankEntity = new BankEntity();
		bankEntity.setBankName("My Bank");
		bankEntity.setBic("SOMENODEEX1");
		bankEntity.setIban("CH12010123948132");
		
        BankEntity savedBankEntity = bankRepository.save(bankEntity);

        Assertions.assertNotNull(savedBankEntity.getId()); // Ensure the entity has been assigned an ID (indicating it was saved)
        Assertions.assertEquals(savedBankEntity.getBankName(), bankEntity.getBankName()); // Ensure the name is saved correctly
	}
}
