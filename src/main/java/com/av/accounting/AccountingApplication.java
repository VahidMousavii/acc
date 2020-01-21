package com.av.accounting;

import com.av.accounting.entity.User;
import com.av.accounting.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AccountingApplication {
    @Autowired
    UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(AccountingApplication.class, args);
    }
}
