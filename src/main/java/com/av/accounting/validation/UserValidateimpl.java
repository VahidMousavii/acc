package com.av.accounting.validation;

import com.av.accounting.entity.User;

public class UserValidateimpl implements UserValidate {
    public String userValidation(User user) {
        if (user.getName() == null || user.getName().equals("")) {
            return "name of user cannot be empty";
        }
        if (user.getPhone() == null || user.getPhone().equals("")) {
            return "phone of user cannot be empty";

        }
        if (user.getPhone().contains("a") && user.getPhone().contains("b")) {
            System.out.println("dadash dari eshtebah mizani");
            return "phone of user cannot contains any a and b characters";
        }
        return Phrases.success;

    }
}
