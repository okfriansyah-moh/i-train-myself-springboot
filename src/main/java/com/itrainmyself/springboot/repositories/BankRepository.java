package com.itrainmyself.springboot.repositories;

import com.itrainmyself.springboot.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
