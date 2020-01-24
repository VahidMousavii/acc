package com.av.accounting;


import com.av.accounting.entity.Account;
import com.av.accounting.entity.Transaction;
import com.av.accounting.entity.User;
import com.av.accounting.repositories.AccountRepository;
import com.av.accounting.repositories.TransactionRepository;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.av.accounting.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountingApplicationTests {

  /*  @Autowired
    UserDA userDAimpl2;
*/


    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;


    /* @Test
     void userInsert() {
         User user=new User(null,"salamdonya2","9992",null,null);

         userDAimpl2.addUser(user);



     }
 */
    @Test
    void addToDB() {
        User user = new User();
        user.setName("mamad");
        user.setPhone("111");

        List<Account> accountList = new ArrayList<>();

        Account account = new Account();
        account.setCardNumber("232323");
        account.setUser(user);
        accountList.add(account);

        user.setAccountList(accountList);

        userRepository.save(user);

        /*List<Transaction> transactions = transactionRepository.findAllByAccount_CardNumber("09999");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getPrice());
        }*/

    }
   /* @Test
    void addUser() {
        User user = new User();
        user.setID(1L);
        List<Account> accountList = accountRepository.findAllByUser(user);
        for (Account account : accountList) {
            System.out.println(accountList);

        }


    }
    @Test
    void transactionByAccount(){
        User user=new User();
        user.setID(1L);
        List<Account> accountList = accountRepository.findAllByUser(user);
        for (Account account : accountList) {
            System.out.println(account.getCardNumber());
        }

    }*/


}

