package com.gantner.demo.iban.ibanvalidator.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gantner.demo.bank.ibanvalidator.ValidatorApplication;
import com.gantner.demo.bank.ibanvalidator.validation.api.internal.ValidationRequest;
import com.gantner.demo.bank.ibanvalidator.validation.api.internal.ValidationResult;
import com.gantner.demo.bank.ibanvalidator.validation.service.BankService;

@SpringBootTest(classes = ValidatorApplication.class)
@AutoConfigureMockMvc
/**
 * @author Stefan Gantner
 */
public class BankControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankService bankService;

    @Test
	void contextLoads() {}

    @Test
    void testValidateIban() throws Exception {
        // Set up mock data for the service
        String iban = "some iban";
        ValidationResult toReturn = new ValidationResult();
        toReturn.setBankName("Some bankName");
        toReturn.setBic("This is a bic");
        toReturn.setValid(true);
        when(bankService.validateIBAN(iban)).thenReturn(toReturn);

        // Perform the POST request to the endpoint
        ValidationRequest request = new ValidationRequest();
        request.setIban(iban);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(request);

       String responseJson = mockMvc.perform(
            post("/api/validate-iban")
            .content(requestBody)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
        .getResponse()
        .getContentAsString();

        // Deserialize the JSON response to ValidationResult class
        ValidationResult validationResponse = objectMapper.readValue(responseJson, ValidationResult.class);

        // Now check the properties of the ValidationResult object
        assertTrue(validationResponse.isValid());
        assertEquals(toReturn.getBankName(), validationResponse.getBankName());
    }

}
