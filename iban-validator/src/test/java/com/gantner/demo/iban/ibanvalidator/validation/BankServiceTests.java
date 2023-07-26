package com.gantner.demo.iban.ibanvalidator.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gantner.demo.bank.ibanvalidator.ValidatorApplication;
import com.gantner.demo.bank.ibanvalidator.validation.service.BankService;

@SpringBootTest(classes = ValidatorApplication.class)
/**
 * @author Stefan Gantner
 */
public class BankServiceTests {

	@Autowired
	BankService bankService;

	@Test
	void contextLoads() {}

	@Test
	void testIbanStringCleaning() {
		String iban = "DE49-7016-3370-0000-6001 13";
		assertEquals("DE49701633700000600113", bankService.cleanIbanString(iban));
	}
}
