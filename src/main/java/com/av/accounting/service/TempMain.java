/*
package com.av.accounting.service;

import com.av.accounting.DA.UserDAimpl;
import com.av.accounting.entity.Account;
import com.av.accounting.entity.Transaction;
import com.av.accounting.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TempMain {

    */
/* public static void main(String[] args) {
         UserDA userDA=new UserDA();
         User user=new User();
         user.setID(8L);
         user.setName("sd8888f");
         user.setPhone("999888888889999");
         userDA.addUser(user);

         Account account=new Account();
         account.setID(1L);
         account.setCardNumber("122");
         account.setUser(user);
         AccountDA accountDA=new AccountDA();
         accountDA.insertToDB(account);
         Transaction transaction=new Transaction();
         transaction.setTRANSACTION_ID(1L);
         transaction.setPrice(BigDecimal.valueOf(12000000L));
         transaction.setUser(user);
         transaction.setMmuserAccount(account);
         TransactionDA transactionDA=new TransactionDA();
         transactionDA.insertToDB(transaction);
     }*//*

    public static void main(String[] args) {
        User user = new User();
//        user.setID(1L);
        user.setName("ali");
        user.setPhone("0912");

        Account account = new Account();
//        account.setAccountID(1L);
        account.setCardNumber("5555");
        account.setCVV2("333");

        Account account2 = new Account();
//        account2.setAccountID(2L);
        account2.setCardNumber("6970");
        account2.setCVV2("436");

        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(account2);
        user.setAccountList(accounts);

        Transaction transaction = new Transaction();
        transaction.setPrice(new BigDecimal(100));
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        user.setTransactionList(transactions);
        account2.setTransactionList(transactions);

        UserDAimpl userDA=new UserDAimpl();
        userDA.addUser(user);

    }
}
*/
