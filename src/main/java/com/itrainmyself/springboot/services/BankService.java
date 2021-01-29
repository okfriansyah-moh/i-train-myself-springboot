package com.itrainmyself.springboot.services;

import com.itrainmyself.springboot.entity.Bank;
import com.itrainmyself.springboot.repositories.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    private BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getAllBank() {
        /**
         * Logic to get all bank data
         */
        return bankRepository.findAll();
    }
}
