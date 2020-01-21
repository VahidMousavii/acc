package com.av.accounting.validation;

import com.av.accounting.entity.Account;

public class AccountValidateimpl implements AccountValidate{
    public String checkAccount(Account account){
        if (!account.getCardNumber().equals("")||account.getCardNumber().contains("a")) return "deghat kon";
        return Phrases.success;
    }
}
