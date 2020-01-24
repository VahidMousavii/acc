package com.av.accounting.validation;

import com.av.accounting.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountValidateimpl implements AccountValidate {
    public String checkAccount(Account account) {
        if (account.getCardNumber().equals("")) {
            return "CardNumber cannot be empty";
        } else if (account.getCVV2().equals("")) {
            return "CVV2 Cannot be empty";
        }
            return "Successfully";



    }
}
