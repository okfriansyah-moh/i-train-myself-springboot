package com.itrainmyself.springboot.controller;

import com.itrainmyself.springboot.entity.Bank;
import com.itrainmyself.springboot.services.BankService;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {
    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/banks")
    public List<Bank> getAllBanks() {
        /**
         * Controller to get all banks
         */
        return bankService.getAllBank();
    }
}
