package com.av.accounting.repositories;


import com.av.accounting.entity.Account;
import com.av.accounting.entity.Transaction;
import com.av.accounting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    List<Transaction> findAllByUser(User user);
    List<Transaction> findAllByAccount(Account account);
    List<Transaction> findAllByAccount_CardNumber(String cardNumber);

}
