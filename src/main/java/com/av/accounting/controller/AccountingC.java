package com.av.accounting.controller;

import com.av.accounting.entity.Account;
import com.av.accounting.entity.User;
import com.av.accounting.repositories.AccountRepository;
import com.av.accounting.validation.AccountValidate;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import com.av.accounting.validation.AccountValidateimpl;
import com.av.accounting.validation.Phrases;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/user_accounting")
public class AccountingC {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountValidate accountValidate;


    @Path("/selectAll")
    @GET
    @Produces(Phrases.text_html)
    public String getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        Gson gson = new Gson();
        String jj = gson.toJson(accounts);
        return jj;
    }


    public String addAccount(@NotNull @QueryParam("cardNumber") String cardNumber, @NotNull @QueryParam("CVV2") String CVV2, @NotNull @QueryParam("expiryDate") String exp, @QueryParam("createDate") String createDate) {
        Account account = new Account();
        String checkAccount = accountValidate.checkAccount(account);
        if (!checkAccount.equals(Phrases.success)) {
            return checkAccount;
        }

        accountRepository.save(account);
        return "Successfully";

    }

    public String allAccountByUser(@QueryParam("User_ID") Long userID) {
        User user = new User();
        user.setID(userID);

        accountRepository.findAllByUser(user);



        return "Successfully";

    }


}


