package com.gantner.demo.bank.ibanvalidator.validation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gantner.demo.bank.ibanvalidator.validation.api.internal.ValidationRequest;
import com.gantner.demo.bank.ibanvalidator.validation.api.internal.ValidationResult;
import com.gantner.demo.bank.ibanvalidator.validation.service.BankService;

import jakarta.annotation.Nonnull;

@RestController
@RequestMapping("/api")
/**
 * THe controller for bank api request handling
 * @author Stefan Gantner
 */
public class BankController {

    private final BankService bankService;

    public BankController(@Nonnull BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("validate-iban")
    /*
     * Validates any string if it contains a valid iban, after the string has been cleaned from unnallowed characters
     * 
     * @return ValidationResult Enity as JSON response data object
     */
    public ResponseEntity<?> validateIBAN(@RequestBody ValidationRequest request) {
        ValidationResult validationResult = bankService.validateIBAN(request.getIban());
        return ResponseEntity.ok(validationResult);
    }
}
