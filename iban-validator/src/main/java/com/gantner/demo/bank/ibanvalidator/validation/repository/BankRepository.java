package com.gantner.demo.bank.ibanvalidator.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gantner.demo.bank.ibanvalidator.validation.entity.BankEntity;
/**
 * The bank repository for saving and finding bank data based on iban
 *
 * @author Stefan Gantner
 *
 */
public interface BankRepository extends JpaRepository<BankEntity, Long> {
    BankEntity findByIban(String iban);
}
