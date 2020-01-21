package com.av.accounting.controller;

import com.av.accounting.entity.Account;
import com.av.accounting.entity.Transaction;
import com.av.accounting.entity.User;
import com.av.accounting.repositories.TransactionRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/user_transaction")
public class TransactionC {

    @Autowired
    TransactionRepository transactionRepository;


    @Path("/selectByUser")
    @GET
    @Produces("text/html")
    public String AllTransactionsByUser(@QueryParam("id") Long id) {
        User user = new User();
        user.setID(id);

        List<Transaction> transactionS = transactionRepository.findAllByUser(user);

        Gson gson = new Gson();
        return gson.toJson(transactionS);
    }

    @Path("/selectByCardNumber")
    @GET
    @Produces("text/html")
    public String AllTransactionsByCardNumber(@QueryParam("cardNumber") String cardNumber) {
        Account account = new Account();
        account.setCardNumber(cardNumber);
        List<Transaction> transactionS = transactionRepository.findAllByAccount_CardNumber(account.getCardNumber());

        Gson gson = new Gson();
        return gson.toJson(transactionS);
    }



}
