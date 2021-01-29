package com.itrainmyself.springboot.repositories;

import com.itrainmyself.springboot.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
