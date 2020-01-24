package com.av.accounting.validation;

import com.av.accounting.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidateimpl implements UserValidate {
    User user = new User();

    public String userValidation(User user) {
        if (user.getName().equals("")) {
            return "Name Cannot Be Empty";
        }
        if (user.getPhone().equals("")) {
            return "Phone Cannot Be Empty";
        }
        return "Successfully";


    }


}
