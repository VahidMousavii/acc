package com.av.accounting.controller;

import com.av.accounting.entity.Account;
import com.av.accounting.entity.User;
import com.av.accounting.repositories.AccountRepository;
import com.av.accounting.validation.AccountValidate;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import com.av.accounting.validation.Phrases;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/user_account")
public class AccountC {
    @Autowired
    AccountValidate accountValidate;
    private AccountRepository accountRepository;

    @Autowired
    public AccountC(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @GetMapping(path = "/findAll")
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @GetMapping(path = "/addAccount")
    public String addAccount(@RequestParam("cardNumber") String cardNumber, @RequestParam("CVV2") String CVV2,
                             @RequestParam("expDate") String exp, @RequestParam("createDate") String createDate) {

        Account account = new Account();
        account.setCardNumber(cardNumber);
        account.setCVV2(CVV2);
        account.setExpiryDate(exp);
       String accvalidate = accountValidate.checkAccount(account);
        if (accvalidate.equals("Successfully")){
            accountRepository.save(account);
            Gson gson = new Gson();
            String khuruji = gson.toJson(account);
            return khuruji;
        } else { return accvalidate; }

    }

    @GetMapping(path = "/allByUser")
    public String allAccountByUser(@RequestParam("User_ID") Long userID) {
        User user = new User();
        user.setID(userID);

        accountRepository.findAllByUser(user);


        return "Successfully";

    }


}


