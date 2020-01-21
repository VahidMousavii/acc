package com.av.accounting.controller;

import com.av.accounting.entity.User;
import com.av.accounting.repositories.UserRepository;
import com.av.accounting.validation.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.av.accounting.validation.Phrases;
import com.av.accounting.validation.UserValidateimpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/user")
public class UserC {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserValidate userValidate;

    @Path("/selectAll")
    @GET
    @Produces("text/html")
    public ResponseEntity<List<User>> getAllAccount() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }


    @Path("/add")
    @GET
    @Produces(Phrases.text_html)
    public String addUser(@QueryParam("name") String name, @QueryParam("phone") String phone) {
        User user = new User(null, name, phone, null, null);
        String validateOfUser = userValidate.userValidation(user);
        if (!validateOfUser.equals("success")) {
            return validateOfUser;
        }
        userRepository.save(user);
        return "doroste";
    }

}


